package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.util.objects2.Objects2;

import java.time.temporal.Temporal;

public class HistoryItem<T extends Temporal, I extends Value<I>> implements Value<HistoryItem<T, I>> {

    private Interval<T> interval;
    private I item;

    public HistoryItem(Interval<T> anInterval, I anItem) {
        interval = anInterval;
        item = anItem;
    }

    I getItem() {
        return item;
    }

    Interval<T> getInterval() {
        return interval;

    }

    @Override
    public boolean sameValueAs(HistoryItem<T, I> other) {
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
        HistoryItem<?, ?> that = (HistoryItem<?, ?>) o;
        return Objects2.equal(item, that.item) &&
                Objects2.equal(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(item, interval);

    }


    public boolean isContinuous(HistoryItem<T, I> aNextHistoryItem) {
        return interval.isContinuousFrom(aNextHistoryItem.interval);
    }

    public HistoryItem<T, I> merge(HistoryItem<T, I> aNextHistoryItem) {
        Interval<T> newInterval = interval.marge(aNextHistoryItem.interval);

        return HistoryItem.createFrom(newInterval, item);

    }

    public static <T extends Temporal, V extends Value<V>> HistoryItem<T, V> createFrom(Interval<T> anInterval, V anItem) {
        return new HistoryItem(anInterval, anItem);

    }

    public HistoryItem<T, I> adjustEndMoment(HistoryItem<T, I> aNextHistoryItem) {
        Interval newInterval = interval.adjustEndMoment(aNextHistoryItem.interval);
        return HistoryItem.createFrom(newInterval, item);

    }

    public boolean isOverlap(HistoryItem<T, I> aNextHistoryItem) {
        return interval.isOverlap(aNextHistoryItem.interval);

    }

    public boolean sameItemAs(HistoryItem<T, I> anOtherHistoryItem) {
        return item.sameValueAs(anOtherHistoryItem.item);

    }

}

