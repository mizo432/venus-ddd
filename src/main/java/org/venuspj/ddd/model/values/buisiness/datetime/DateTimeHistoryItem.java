package org.venuspj.ddd.model.values.buisiness.datetime;


import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.momentinterval.DateTimeInterval;
import org.venuspj.util.objects2.Objects2;

public class DateTimeHistoryItem<I extends Value<I>> implements Value<DateTimeHistoryItem<I>> {
    private DateTimeInterval interval;
    private I item;


    I getItem() {
        return item;
    }

    DateTimeInterval getInterval() {
        return interval;

    }

    @Override
    public boolean sameValueAs(DateTimeHistoryItem<I> other) {
        return equals(other);

    }

    @Override
    public boolean isEmpty() {
        return item.isEmpty() && interval.isEmpty();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateTimeHistoryItem<?> that = (DateTimeHistoryItem<?>) o;
        return Objects2.equal(item, that.item) &&
                Objects2.equal(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(item, interval);

    }

    public boolean sameItemAs(DateTimeHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return false;
    }

    public boolean isContinuous(DateTimeHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return false;
    }

    public DateTimeHistoryItem<I> merge(DateTimeHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return null;
    }

    public boolean isOverlap(DateTimeHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return false;
    }

    public DateTimeHistoryItem<I> adjustEndDate(DateTimeHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return null;
    }
}
