package org.venuspj.basic.model.domain.relashonshipManagement.party;


import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.momentinterval.YearInterval;
import org.venuspj.util.objects2.Objects2;

public class HistoryItem<I extends Value<I>> implements Value<HistoryItem<I>> {
    private I item;


    private YearInterval yearInterval;

    I getItem() {
        return item;
    }

    YearInterval getYearInterval() {
        return yearInterval;

    }

    @Override
    public boolean sameValueAs(HistoryItem<I> other) {
        return equals(other);

    }

    @Override
    public boolean isEmpty() {
        return item.isEmpty() && yearInterval.isEmpty();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryItem<?> that = (HistoryItem<?>) o;
        return Objects2.equal(item, that.item) &&
                Objects2.equal(yearInterval, that.yearInterval);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(item, yearInterval);
    }
}
