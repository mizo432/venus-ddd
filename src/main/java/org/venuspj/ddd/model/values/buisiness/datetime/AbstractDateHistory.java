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
public abstract class AbstractDateHistory<
        E extends Value<E>,
        H extends AbstractDateHistory<E, H>>
        extends AbstractListValue<DateHistoryItem<E>, H> {

    protected AbstractDateHistory(Collection<DateHistoryItem<E>> aCollection) {
        super(aCollection);
    }

    public AbstractDateHistory() {
        super();
    }

    protected E findBy(TargetDate aTargetMoment) {
        Optional<DateHistoryItem<E>> resultOptional = value.stream()
                .filter(historyItem -> historyItem.getInterval().contains(aTargetMoment))
                .findFirst();

        if (resultOptional.isEmpty())
            return resultOptional.get().getItem();
        return null;

    }

    protected static class NormalizationHistory<T extends Value<T>> {
        private ArrayList<DateHistoryItem<T>> list = newArrayList();

        NormalizationHistory(List<DateHistoryItem<T>> aList) {
            list.addAll(aList);
        }

        public ArrayList<DateHistoryItem<T>> normalize() {
            ArrayList<DateHistoryItem<T>> result = newArrayList();
            for (int sourceIndex = 0; sourceIndex < list.size(); sourceIndex++) {
                DateHistoryItem<T> thisHistoryItem = list.get(sourceIndex);
                if (result.isEmpty())
                    result.add(thisHistoryItem);

                else {
                    DateHistoryItem<T> lastHistoryItem = result.get(result.size() - 1);
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

        public static <T extends Value<T>> NormalizationHistory<T> of(List<DateHistoryItem<T>> anyArgs) {
            return new NormalizationHistory(anyArgs);
        }

    }


}
