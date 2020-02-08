package org.venuspj.basic.model.domain.relashonshipManagement.party;


import org.venuspj.ddd.model.values.Value;
import org.venuspj.util.objects2.Objects2;

public class HistoryItem<I extends Value<I>> implements Value<HistoryItem<I>> {
    private I item;


    private AvailableInterval availableInterval;

    I getItem() {
        return item;
    }

    AvailableInterval getAvailableInterval() {
        return availableInterval;
    }

    @Override
    public boolean sameValueAs(HistoryItem<I> other) {
        return equals(other);
    }

    @Override
    public boolean isEmpty() {
        return item.isEmpty() && availableInterval.isEmpty();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryItem<?> that = (HistoryItem<?>) o;
        return Objects2.equal(item, that.item) &&
                Objects2.equal(availableInterval, that.availableInterval);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(item, availableInterval);
    }
}
