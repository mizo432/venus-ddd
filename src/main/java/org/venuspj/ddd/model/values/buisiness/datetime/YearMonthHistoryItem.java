package org.venuspj.ddd.model.values.buisiness.datetime;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.momentinterval.YearMonthInterval;
import org.venuspj.util.objects2.Objects2;

public class YearMonthHistoryItem<I extends Value<I>> implements Value<YearMonthHistoryItem<I>> {
    private YearMonthInterval interval;
    private I item;


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


    public boolean sameItemAs(YearMonthHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return false;
    }

    public boolean isContinuous(YearMonthHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return false;
    }

    public YearMonthHistoryItem<I> merge(YearMonthHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return null;
    }

    public boolean isOverlap(YearMonthHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return false;
    }

    public YearMonthHistoryItem<I> adjustEndDate(YearMonthHistoryItem<I> thisHistoryItem) {
        // TODO atdk
        return null;
    }
}
