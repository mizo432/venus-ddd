package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

/**
 * 履歴データ基底データ
 */
public class AbstractYearMonthHistory<
        E extends Value<E>,
        H extends AbstractYearMonthHistory<E, H>>
        extends AbstractListValue<YearMonthHistoryItem<E>, H> {

    public E findBy(TargetYearMonth aTargetMoment) {
        return null;

    }

}
