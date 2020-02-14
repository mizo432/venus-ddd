package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.util.Collection;
import java.util.List;

public class DateHistoryItems<T1 extends Value<T1>> extends AbstractListValue<T1, DateHistoryItems<T1>> {
    public DateHistoryItems(Collection<DateHistoryItem<T1>> aCollection) {

    }

    public static <T1 extends Value<T1>> DateHistoryItems<T1> of(List<DateHistoryItem<T1>> aCollection) {
        return new DateHistoryItems<>(aCollection);
    }
}
