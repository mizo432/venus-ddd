package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 日付をキーにした交差エンティティの一覧
 *
 * @param <V1> 交差エンティティの最初の値の型
 * @param <V2> 交差エンティティの二番目値の型
 */
public class DateIntersections<V1 extends Value<V1>, V2 extends Value<V2>>
        extends AbstractListValue<DateIntersection<V1, V2>, DateIntersections<V1, V2>> {

    @Override
    public DateIntersection<V1, V2> findBy(Predicate<DateIntersection<V1, V2>> aPredicate) {
        return super.findBy(aPredicate);
    }

    public DateHistoryItems<V1> selectFirstValuesBy(Predicate<DateIntersection<V1, V2>> aPredicate) {
        List<DateHistoryItem<V1>> result = value.stream()
                .filter(aPredicate)
                .map(momentIntersection -> DateHistoryItem.createFrom(momentIntersection.getDateInterval(),
                        momentIntersection.getFirstValue()))
                .collect(Collectors.toList());

        return DateHistoryItems.of(result);

    }

    public DateHistoryItems<V2> selectSecondValuesBy(Predicate<DateIntersection<V1, V2>> aPredicate) {
        List<DateHistoryItem<V2>> result = value.stream()
                .filter(aPredicate)
                .map(momentIntersection -> DateHistoryItem.createFrom(momentIntersection.getDateInterval(),
                        momentIntersection.getSecondValue()))
                .collect(Collectors.toList());

        return DateHistoryItems.of(result);

    }
}
