package org.venuspj.ddd.model.values.buisiness.datetime;


import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.momentinterval.YearInterval;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.isNull;

public class YearHistoryItem<I extends Value<I>> extends AbstractValue<YearHistoryItem<I>> {
    private YearInterval interval = YearInterval.empty();
    private I item;

    YearHistoryItem(YearInterval anInterval, I anItem) {
        interval = anInterval;
        item = anItem;

    }

    public YearHistoryItem() {

    }

    public static <T extends Value<T>> YearHistoryItem<T> empty() {
        return new YearHistoryItem<>();
    }

    public static <T extends Value<T>> YearHistoryItem<T> createFrom(YearInterval anInterval, T anItem) {
        return new YearHistoryItem<>(anInterval, anItem);
    }


    I getItem() {
        return item;
    }

    YearInterval getInterval() {
        return interval;

    }

    @Override
    public boolean sameValueAs(YearHistoryItem<I> other) {
        return equals(other);

    }

    @Override
    public boolean isEmpty() {
        return isNull(item) || (item.isEmpty() && interval.isEmpty());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearHistoryItem<?> that = (YearHistoryItem<?>) o;
        return Objects2.equal(item, that.item) &&
                Objects2.equal(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(item, interval);

    }

    public boolean sameItemAs(YearHistoryItem<I> aYearHistoryItem) {
        return item.sameValueAs(aYearHistoryItem.item);
    }

    public I item() {
        return item;
    }

    public YearInterval.DefaultYearValue decrementStartMoment() {
        return interval.decrementStartMoment();
    }

    public YearHistoryItem<I> renewEndDate(YearInterval.DefaultYearValue aEndDate) {
        YearHistoryItem<I> result = YearHistoryItem.createFrom(interval.renewEndDate(aEndDate), item);
        return result;

    }

    public boolean isOverlap(YearHistoryItem<I> other) {
        return interval.isOverlap(other.interval);
    }
}
