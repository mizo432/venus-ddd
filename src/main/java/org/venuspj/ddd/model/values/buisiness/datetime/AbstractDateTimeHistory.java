package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.venuspj.util.collect.Lists2.newArrayList;

/**
 * 履歴データ基底データ
 */
public abstract class AbstractDateTimeHistory<
        E extends Value<E>,
        H extends AbstractDateTimeHistory<E, H>>
        extends AbstractListValue<DateTimeHistoryItem<E>, H> {

    protected AbstractDateTimeHistory(Collection<DateTimeHistoryItem<E>> aCollection) {
        super(aCollection);
    }

    public AbstractDateTimeHistory() {
        super();
    }

    protected E findBy(TargetDateTime aTargetMoment) {
        Optional<DateTimeHistoryItem<E>> resultOptional = value.stream()
                .filter(historyItem -> historyItem.getInterval().contains(aTargetMoment))
                .findFirst();

        if (resultOptional.isEmpty())
            return resultOptional.get().getItem();
        return null;

    }

    protected static class NormalizationHistory<T extends Value<T>> {
        private ArrayList<DateTimeHistoryItem<T>> list = newArrayList();

        NormalizationHistory(List<DateTimeHistoryItem<T>> aList) {
            list.addAll(aList);
        }

        public ArrayList<DateTimeHistoryItem<T>> normalize() {
            ArrayList<DateTimeHistoryItem<T>> result = newArrayList();
            for (int sourceIndex = 0; sourceIndex < list.size(); sourceIndex++) {
                DateTimeHistoryItem<T> thisHistoryItem = list.get(sourceIndex);
                if (result.isEmpty())
                    result.add(thisHistoryItem);

                else {
                    DateTimeHistoryItem<T> lastHistoryItem = result.get(result.size() - 1);
                    if (lastHistoryItem.sameItemAs(thisHistoryItem)) {
                        // ヒストリーのアイテムが前と一致していた場合
                        if (lastHistoryItem.isContinuous(thisHistoryItem)) {
                            // ヒストリーのインターバルが前と連続していた場合
                            result.set(result.size() - 1, lastHistoryItem.merge(thisHistoryItem));

                        } else {
                            if (lastHistoryItem.isOverlap(thisHistoryItem)) {
                                result.set(result.size() - 1, lastHistoryItem.merge(thisHistoryItem));

                            } else {
                                result.add(thisHistoryItem);

                            }

                        }

                    } else {
                        // ヒストリーアイテムが違っていた場合
                        if (lastHistoryItem.isContinuous(thisHistoryItem)) {

                        } else {
                            if (lastHistoryItem.isOverlap(thisHistoryItem)) {
                                result.set(result.size() - 1, lastHistoryItem.adjustEndDate(thisHistoryItem));

                            }

                        }
                        result.add(thisHistoryItem);

                    }
                }
            }
            return result;
        }

        public static <T extends Value<T>> NormalizationHistory<T> of(List<DateTimeHistoryItem<T>> anyArgs) {
            return new NormalizationHistory(anyArgs);
        }

    }


}
