package org.venuspj.ddd.model.values.buisiness.datetime;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.momentinterval.YearMonthInterval;
import org.venuspj.util.objects2.Objects2;

public class YearMonthHistoryItem<I extends Value<I>> implements Value<YearMonthHistoryItem<I>> {
    private YearMonthInterval interval;
    private I item;

    public YearMonthHistoryItem(YearMonthInterval anInterval, I anItem) {
        interval = anInterval;
        item = anItem;
    }


    I getItem() {
        return item;
    }

    YearMonthInterval getInterval() {
        return interval;

    }

    @Override
    public boolean sameValueAs(YearMonthHistoryItem<I> other) {
        return equals(other);

    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return item.isEmpty() && interval.isEmpty();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        YearMonthHistoryItem<?> that = (YearMonthHistoryItem<?>) o;
        return Objects2.equal(item, that.item) &&
                Objects2.equal(interval, that.interval);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(item, interval);

    }


    public boolean sameItemAs(YearMonthHistoryItem<I> anOtherHistoryItem) {
        return item.sameValueAs(anOtherHistoryItem.item);
    }

    public boolean isContinuous(YearMonthHistoryItem<I> aNextHistoryItem) {
        return interval.isContinuous(aNextHistoryItem.interval);
    }

    public YearMonthHistoryItem<I> merge(YearMonthHistoryItem<I> aNextHistoryItem) {
        YearMonthInterval newInterval = interval.marge(aNextHistoryItem.interval);

        return YearMonthHistoryItem.createFrom(newInterval, item);


    }

    public static <I extends Value<I>> YearMonthHistoryItem<I> createFrom(YearMonthInterval anInterval, I anItem) {
        return new YearMonthHistoryItem<>(anInterval, anItem);
    }

    public YearMonthHistoryItem<I> adjustEndMoment(YearMonthHistoryItem<I> aNextHistoryItem) {
        YearMonthInterval newInterval = interval.adjustEndMoment(aNextHistoryItem.interval);
        return YearMonthHistoryItem.createFrom(newInterval, item);

    }

    public boolean isOverlap(YearMonthHistoryItem<I> aNextHistoryItem) {
        return interval.isOverlap(aNextHistoryItem.interval);

    }
}
