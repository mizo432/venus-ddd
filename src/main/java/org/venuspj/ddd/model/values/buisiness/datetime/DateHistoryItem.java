package org.venuspj.ddd.model.values.buisiness.datetime;


import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.momentinterval.DateInterval;
import org.venuspj.util.objects2.Objects2;

public class DateHistoryItem<I extends Value<I>> implements Value<DateHistoryItem<I>> {
    private DateInterval interval;
    private I item;

    public DateHistoryItem(DateInterval anInterval, I anItem) {
        interval = anInterval;
        item = anItem;
    }


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


    public boolean isContinuous(DateHistoryItem<I> aNextHistoryItem) {
        return interval.isContinuous(aNextHistoryItem.interval);
    }

    public DateHistoryItem<I> merge(DateHistoryItem<I> aNextHistoryItem) {
        DateInterval newInterval = interval.marge(aNextHistoryItem.interval);

        return DateHistoryItem.createFrom(newInterval, item);

    }

    private static <I extends Value<I>> DateHistoryItem<I> createFrom(DateInterval anInterval, I anItem) {
        return new DateHistoryItem(anInterval, anItem);

    }

    public DateHistoryItem<I> adjustEndMoment(DateHistoryItem<I> aNextHistoryItem) {
        DateInterval newInterval = interval.adjustEndMoment(aNextHistoryItem.interval);
        return DateHistoryItem.createFrom(newInterval, item);

    }

    public boolean isOverlap(DateHistoryItem<I> aNextHistoryItem) {
        return interval.isOverlap(aNextHistoryItem.interval);

    }

    public boolean sameItemAs(DateHistoryItem<I> anOtherHistoryItem) {
        return item.sameValueAs(anOtherHistoryItem.item);

    }

}
