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
public abstract class AbstractYearHistory<
        E extends Value<E>,
        H extends AbstractYearHistory<E, H>>
        extends AbstractListValue<YearHistoryItem<E>, H> {

    protected AbstractYearHistory(Collection<YearHistoryItem<E>> aCollection) {
        super(aCollection);
    }

    public AbstractYearHistory() {
        super();
    }

    protected E findBy(TargetYear aTargetMoment) {
        Optional<YearHistoryItem<E>> resultOptional = value.stream()
                .filter(historyItem -> historyItem.getInterval().contains(aTargetMoment))
                .findFirst();

        if (resultOptional.isEmpty())
            return resultOptional.get().getItem();
        return null;

    }

    protected static class NormalizationHistory<T extends Value<T>> {
        private ArrayList<YearHistoryItem<T>> list = newArrayList();

        public NormalizationHistory(List<YearHistoryItem<T>> aList) {
            list.addAll(aList);
        }

        public ArrayList<YearHistoryItem<T>> normalize() {
            ArrayList<YearHistoryItem<T>> result = newArrayList();
            for (int sourceIndex = 0; sourceIndex < list.size(); sourceIndex++) {
                YearHistoryItem<T> thisHistoryItem = list.get(sourceIndex);
                if (result.isEmpty())
                    result.add(thisHistoryItem);

                else {
                    YearHistoryItem<T> lastHistoryItem = result.get(result.size() - 1);
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
                                result.set(result.size() - 1, lastHistoryItem.adjustEndMoment(thisHistoryItem));

                            }

                        }
                        result.add(thisHistoryItem);

                    }
                }
            }
            return result;
        }

        public static <T extends Value<T>> NormalizationHistory<T> of(List<YearHistoryItem<T>> anyArgs) {
            return new NormalizationHistory(anyArgs);
        }

    }


}
