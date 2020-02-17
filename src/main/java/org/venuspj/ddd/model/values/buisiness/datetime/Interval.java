package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.util.objects2.Objects2;

import java.time.temporal.Temporal;

public class Interval<T extends Temporal> extends AbstractValue<Interval<T>> {
    Moment<T> startMoment = Moment.empty();
    Moment<T> endMoment = Moment.empty();

    public Interval(Moment<T> aStartMoment, Moment<T> anEndMoment) {
        startMoment = aStartMoment;
        endMoment = anEndMoment;
    }

    public static <T extends Temporal> Interval<T> createFrom(Moment<T> aStartMoment, Moment<T> anEndMoment) {
        return new Interval<>(aStartMoment, anEndMoment);

    }

    public static <T extends Temporal> Interval<T> createFrom(Moment<T> aStartMoment) {
        return new Interval<>(aStartMoment, aStartMoment.maxMoment());
    }

    @Override
    public boolean sameValueAs(Interval<T> other) {
        return equals(other);
    }

    @Override
    public boolean isEmpty() {
        return startMoment.isEmpty() &&
                endMoment.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interval<?> interval = (Interval<?>) o;
        return Objects2.equal(startMoment, interval.startMoment) &&
                Objects2.equal(endMoment, interval.endMoment);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(startMoment, endMoment);

    }

    /**
     * 指定のインターバルから連続しているかを判例します。
     *
     * @param anInterval 指定のインターバル
     * @return 連続している場合trueを返却します。
     */
    public boolean isContinuousTo(Interval<T> anInterval) {
        return this.endMoment.equals(anInterval.startMoment.decrementalMoment());

    }

    /**
     * 指定のインターバルをマージします
     *
     * @param interval 指定のインターバル
     * @return マージされたインターバルを返却します。
     */
    public Interval<T> marge(Interval<T> interval) {
        return Interval.createFrom(startMoment, interval.endMoment());

    }

    public Interval<T> adjustEndMoment(Interval<T> interval) {
        return Interval.createFrom(startMoment, interval.startMoment().decrementalMoment());

    }

    /**
     * 指定のインターバルがオーバーラップしているかを判定します.
     *
     * @param anInterval 指定のインターバル
     * @return オーバーラップしている場合trueを返却します。
     */
    public boolean isOverlap(Interval<T> anInterval) {
        return (startMoment.isBefore(anInterval.endMoment())
                || startMoment.sameValueAs(anInterval.endMoment()))
                && (endMoment.isAfter(anInterval.startMoment())
                || endMoment.sameValueAs(anInterval.startMoment()));

    }

    public boolean contains(Moment<T> aTargetMoment) {
        return (startMoment.isBefore(aTargetMoment) || startMoment.equals(aTargetMoment))
                && (endMoment.isAfter(aTargetMoment) || endMoment.equals(aTargetMoment));

    }

    public Moment<T> startMoment() {
        return startMoment;

    }

    public Moment<T> endMoment() {
        return endMoment;

    }
}
