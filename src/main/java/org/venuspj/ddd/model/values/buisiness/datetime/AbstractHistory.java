package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.venuspj.util.collect.Lists2.newArrayList;

public class AbstractHistory<
        V extends Value<V>,
        H extends AbstractHistory<V, H, T>,
        T extends Temporal>
        extends AbstractListValue<HistoryItem<T, V>, H> {

    protected AbstractHistory(Collection<HistoryItem<T, V>> aCollection) {
        super(aCollection);

    }

    public AbstractHistory() {
        super();
    }

    protected V findBy(Moment<T> aTargetMoment) {
        Optional<HistoryItem<T, V>> resultOptional = value.stream()
                .filter(historyItem -> historyItem.getInterval().contains(aTargetMoment))
                .findFirst();

        if (resultOptional.isEmpty())
            return resultOptional.get().getItem();

        return null;

    }

    protected static class NormalizationHistory<T extends Temporal, V extends Value<V>> {
        private ArrayList<HistoryItem<T, V>> list = newArrayList();

        NormalizationHistory(Collection<HistoryItem<T, V>> aCollection) {
            list.addAll(aCollection);
        }

        public ArrayList<HistoryItem<T, V>> normalize() {
            ArrayList<HistoryItem<T, V>> result = newArrayList();
            for (int sourceIndex = 0; sourceIndex < list.size(); sourceIndex++) {
                HistoryItem<T, V> thisHistoryItem = list.get(sourceIndex);
                if (result.isEmpty())
                    result.add(thisHistoryItem);

                else {
                    HistoryItem<T, V> lastHistoryItem = result.get(result.size() - 1);
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

        public static <T extends Temporal, V extends Value<V>> NormalizationHistory<T, V> of(List<HistoryItem<T, V>> anyArgs) {
            return new NormalizationHistory(anyArgs);
        }

    }

}
