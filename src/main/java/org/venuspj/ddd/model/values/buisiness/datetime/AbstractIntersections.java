package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;
import org.venuspj.util.collect.ComparisonChain;

import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.venuspj.util.collect.Collections3.newHashSet;
import static org.venuspj.util.collect.Lists2.newArrayList;

/**
 * インターバルをキーにした交差エンティティ
 *
 * @param <V1> 交差エンティティの最初の値の型
 * @param <V2> 交差エンティティの二番目値の型
 * @param <T>  履歴の瞬間を表すクラス(Year,YearMonth,LocalDate,LocalDateTimeのいずれか)
 */
public class AbstractIntersections
        <V1 extends Value<V1>,
                V2 extends Value<V2>,
                I extends AbstractIntersections<V1, V2, I, T>,
                T extends Temporal>
        extends AbstractListValue<IntersectionItem<T, V1, V2>, I> {

    public AbstractIntersections(Collection<IntersectionItem<T, V1, V2>> aCollection) {
        super(aCollection);

    }

    public HistoryItems<T, V1> selectFirstItemsBy(V2 aSecondItem) {

        List<HistoryItem<T, V1>> resultList = selectFirstItemListBy(aSecondItem);
        return HistoryItems.of(resultList);

    }

    @SuppressWarnings("unchecked")
    private List selectFirstItemListBy(V2 aSecondItem) {
        List<IntersectionItem<T, V1, V2>> wkList = value.stream()
                .filter(intersectionItem -> intersectionItem.getSecondValue().equals(aSecondItem))
                .collect(Collectors.toList());

        return wkList.stream()
                .map(intersectionItem -> {
                    return (HistoryItem<T, V1>) HistoryItem.createFrom(intersectionItem.getInterval(),
                            intersectionItem.getFirstValue());

                })
                .collect(Collectors.toList());

    }

    public HistoryItems<T, V2> selectSecondItemsBy(V1 aFirstItem) {
        List<HistoryItem<T, V2>> resultList = selectSecondItemListBy(aFirstItem);
        return HistoryItems.of(resultList);

    }

    @SuppressWarnings("unchecked")
    private List<HistoryItem<T, V2>> selectSecondItemListBy(V1 aFirstItem) {
        List<IntersectionItem<T, V1, V2>> wkList = value.stream()
                .filter(intersectionItem -> intersectionItem.getFirstValue().equals(aFirstItem))
                .collect(Collectors.toList());

        return wkList.stream()
                .map(intersectionItem -> {
                    return (HistoryItem<T, V2>) HistoryItem.createFrom(intersectionItem.getInterval(),
                            intersectionItem.getSecondValue());

                })
                .collect(Collectors.toList());

    }

    /**
     * 交差エンティティを正規化する
     * <pre>
     * 重複、オーバーラップを統合する
     * </pre>
     *
     * @param <T>  履歴の瞬間を表すクラス(Year,YearMonth,LocalDate,LocalDateTimeのいずれか)
     * @param <V1> 交差エンティティの最初の値の型
     * @param <V2> 交差エンティティの二番目値の型
     */
    protected static class NormalizationHistory<T extends Temporal, V1 extends Value<V1>, V2 extends Value<V2>> {
        private ArrayList<IntersectionItem<T, V1, V2>> list = newArrayList();

        NormalizationHistory(Collection<IntersectionItem<T, V1, V2>> aCollection) {
            list.addAll(aCollection);
        }

        private NormalizationHistory<T, V1, V2> deleteDuplicateItem() {
            return NormalizationHistory.of(
                    newHashSet(list));

        }

        private NormalizationHistory<T, V1, V2> normalizeOnFirstValue() {
            List<IntersectionItem<T, V1, V2>> sortedList =
                    list
                            .stream()
                            .sorted((o1, o2) -> ComparisonChain.start()
                                    .compare((Comparable<?>) o1.firstValue(), (Comparable<?>) o2.firstValue())
                                    .compare((Comparable<?>) o1.getSecondValue(), (Comparable<?>) o2.getSecondValue())
                                    .compare(o1.getInterval().startMoment(), o2.getInterval().startMoment())
                                    .compare(o1.getInterval().endMoment(), o2.getInterval().endMoment())
                                    .result()).collect(Collectors.toList());
            return normalizeOnSortedValue(sortedList);


        }

        private NormalizationHistory<T, V1, V2> normalizeOnSecondValue() {

            List<IntersectionItem<T, V1, V2>> sortedList =
                    list
                            .stream()
                            .sorted((o1, o2) -> ComparisonChain.start()
                                    .compare((Comparable<?>) o1.getSecondValue(), (Comparable<?>) o2.getSecondValue())
                                    .compare((Comparable<?>) o1.firstValue(), (Comparable<?>) o2.firstValue())
                                    .compare(o1.getInterval().startMoment(), o2.getInterval().startMoment())
                                    .compare(o1.getInterval().endMoment(), o2.getInterval().endMoment())
                                    .result()).collect(Collectors.toList());
            return normalizeOnSortedValue(sortedList);


        }

        private NormalizationHistory<T, V1, V2> normalizeOnSortedValue(List<IntersectionItem<T, V1, V2>> sortedList) {
            List<IntersectionItem<T, V1, V2>> result = newArrayList();
            for (IntersectionItem<T, V1, V2> thisHistoryItem : sortedList) {
                if (result.isEmpty())
                    result.add(thisHistoryItem);

                else {
                    IntersectionItem<T, V1, V2> lastHistoryItem = result.get(result.size() - 1);
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
                        result.add(thisHistoryItem);

                    }
                }
            }
            //return result;

            return NormalizationHistory.of(
                    new HashSet<>(list));
        }

        public static <T extends Temporal, V1 extends Value<V1>, V2 extends Value<V2>> NormalizationHistory<T, V1, V2> of(Collection<IntersectionItem<T, V1, V2>> anyArgs) {
            return new NormalizationHistory<>(anyArgs);

        }

        public ArrayList<IntersectionItem<T, V1, V2>> normalize() {
            return deleteDuplicateItem()
                    .normalizeOnFirstValue()
                    .normalizeOnSecondValue()
                    .getList();

        }

        public ArrayList<IntersectionItem<T, V1, V2>> getList() {
            return list;

        }

        public void setList(ArrayList<IntersectionItem<T, V1, V2>> list) {
            this.list = list;

        }
    }
}
