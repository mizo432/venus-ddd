package org.venuspj.ddd.model.values.buisiness.datetime;


import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.momentinterval.DateTimeInterval;
import org.venuspj.util.objects2.Objects2;

public class DateTimeHistoryItem<I extends Value<I>> implements Value<DateTimeHistoryItem<I>> {
    private DateTimeInterval interval;
    private I item;

    DateTimeHistoryItem(DateTimeInterval aDateTimeInterval, I anItem) {
        interval = aDateTimeInterval;
        item = anItem;

    }


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

    public boolean sameItemAs(DateTimeHistoryItem<I> anOtherHistoryItem) {
        return item.sameValueAs(anOtherHistoryItem.item);
    }

    public boolean isContinuous(DateTimeHistoryItem<I> aNextHistoryItem) {
        return interval.isContinuous(aNextHistoryItem.interval);
    }

    public DateTimeHistoryItem<I> merge(DateTimeHistoryItem<I> aNextHistoryItem) {
        DateTimeInterval newInterval = interval.marge(aNextHistoryItem.interval);

        return DateTimeHistoryItem.createFrom(newInterval, item);

    }

    private static <I extends Value<I>> DateTimeHistoryItem<I> createFrom(DateTimeInterval aDateTimeInterval, I anItem) {
        return new DateTimeHistoryItem(aDateTimeInterval, anItem);

    }

    public DateTimeHistoryItem<I> adjustEndDate(DateTimeHistoryItem<I> aNextHistoryItem) {
        DateTimeInterval newInterval = interval.adjustEndDate(aNextHistoryItem.interval);
        return DateTimeHistoryItem.createFrom(newInterval, item);

    }

    public boolean isOverlap(DateTimeHistoryItem<I> aNextHistoryItem) {
        return interval.isOverlap(aNextHistoryItem.interval);

    }
}
