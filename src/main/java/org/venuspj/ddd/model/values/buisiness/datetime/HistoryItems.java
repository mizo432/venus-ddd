package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.List;

public class HistoryItems<T extends Temporal, V extends Value<V>>
        extends AbstractListValue<HistoryItem<T, V>, HistoryItems<T, V>> {

    public HistoryItems(Collection<HistoryItem<T, V>> aCollection) {
        value.addAll(aCollection);

    }

    public static <T extends Temporal, V extends Value<V>> HistoryItems<T, V> of(List<HistoryItem<T, V>> aCollection) {
        return new HistoryItems<>(aCollection);

    }
}
