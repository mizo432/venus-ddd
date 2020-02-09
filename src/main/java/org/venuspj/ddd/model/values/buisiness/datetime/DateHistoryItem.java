package org.venuspj.ddd.model.values.buisiness.datetime;


import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.momentinterval.DateInterval;
import org.venuspj.util.objects2.Objects2;

public class DateHistoryItem<I extends Value<I>> implements Value<DateHistoryItem<I>> {
    private DateInterval interval;
    private I item;


    I getItem() {
        return item;
    }

    DateInterval getInterval() {
        return interval;

    }

    @Override
    public boolean sameValueAs(DateHistoryItem<I> other) {
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
        DateHistoryItem<?> that = (DateHistoryItem<?>) o;
        return Objects2.equal(item, that.item) &&
                Objects2.equal(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(item, interval);

    }


    public boolean sameItemAs(DateHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return false;
    }

    public boolean isContinuous(DateHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return false;
    }

    public DateHistoryItem<I> merge(DateHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return null;
    }

    public boolean isOverlap(DateHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return false;
    }

    public DateHistoryItem<I> adjustEndDate(DateHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return null;
    }
}
