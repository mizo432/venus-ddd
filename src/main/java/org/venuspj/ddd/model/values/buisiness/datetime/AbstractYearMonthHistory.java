package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.venuspj.util.collect.Lists2.newArrayList;

/**
 * 履歴データ基底データ
 */
public class AbstractYearMonthHistory<
        E extends Value<E>,
        H extends AbstractYearMonthHistory<E, H>>
        extends AbstractListValue<YearMonthHistoryItem<E>, H> {

    public E findBy(TargetYearMonth aTargetMoment) {
        Optional<YearMonthHistoryItem<E>> resultOptional = value.stream()
                .filter(historyItem -> historyItem.getInterval().contains(aTargetMoment))
                .findFirst();

        if (resultOptional.isEmpty())
            return resultOptional.get().getItem();
        return null;

    }

    protected static class NormalizationHistory<T extends Value<T>> {
        private ArrayList<YearMonthHistoryItem<T>> list = newArrayList();

        public NormalizationHistory(List<YearMonthHistoryItem<T>> aList) {
            list.addAll(aList);
        }

        public ArrayList<YearMonthHistoryItem<T>> normalize() {
            ArrayList<YearMonthHistoryItem<T>> result = newArrayList();
            for (int sourceIndex = 0; sourceIndex < list.size(); sourceIndex++) {
                YearMonthHistoryItem<T> thisHistoryItem = list.get(sourceIndex);
                if (result.isEmpty())
                    result.add(thisHistoryItem);

                else {
                    YearMonthHistoryItem<T> lastHistoryItem = result.get(result.size() - 1);
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

        public static <T extends Value<T>> NormalizationHistory<T> of(List<YearMonthHistoryItem<T>> anyArgs) {
            return new NormalizationHistory(anyArgs);
        }

    }

}
