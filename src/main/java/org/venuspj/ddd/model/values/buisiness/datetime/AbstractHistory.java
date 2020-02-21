package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.venuspj.util.collect.Lists2.newArrayList;

/**
 * 履歴情報の基底クラス
 *
 * @param <V> 履歴情報の情報クラス
 * @param <H> 履歴情報の汎化クラス
 * @param <T> 履歴の瞬間を表すクラス(Year,YearMonth,LocalDate,LocalDateTimeのいずれか)
 */
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

    /**
     * ターゲット瞬間を渡し該当するアイテムを返却する
     *
     * @param aTargetMoment ターゲット瞬間
     * @return 履歴管理されているアイテム
     */
    protected V findBy(Moment<T> aTargetMoment) {
        Optional<HistoryItem<T, V>> resultOptional = value.stream()
                .filter(historyItem -> historyItem.getInterval().contains(aTargetMoment))
                .findFirst();

        if (resultOptional.isEmpty())
            return resultOptional.get().getItem();

        return null;

    }

    /**
     * 履歴を正規化する
     * <pre>
     * 重複、オーバーラップを統合する
     * </pre>
     *
     * @param <T> 履歴の瞬間を表すクラス(Year,YearMonth,LocalDate,LocalDateTimeのいずれか)
     * @param <V> 履歴情報の情報クラス
     */
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
