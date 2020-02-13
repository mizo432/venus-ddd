package org.venuspj.ddd.model.values.primitives.momentinterval;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.ddd.model.values.buisiness.datetime.TargetYearMonth;
import org.venuspj.ddd.model.values.primitives.AbstractYearMonthValue;
import org.venuspj.ddd.model.values.primitives.YearMonthValue;

import java.time.YearMonth;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.hash;

public class YearMonthInterval extends AbstractValue<YearMonthInterval> {
    private DefaultYearMonthValue startMoment = DefaultYearMonthValue.empty();
    private DefaultYearMonthValue endMoment = DefaultYearMonthValue.empty();

    YearMonthInterval(DefaultYearMonthValue aStartMoment, DefaultYearMonthValue anEndMoment) {
        startMoment = aStartMoment;
        endMoment = anEndMoment;

    }

    public YearMonthInterval() {

    }

    public static YearMonthInterval createFrom(YearMonthValue<?> aStartMoment, YearMonthValue<?> anEndMoment) {
        return new YearMonthInterval(DefaultYearMonthValue.of(aStartMoment),
                DefaultYearMonthValue.of(anEndMoment));
    }

    public static YearMonthInterval empty() {
        return new YearMonthInterval();
    }

    @Override
    public boolean sameValueAs(YearMonthInterval other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        YearMonthInterval that = (YearMonthInterval) other;
        return equal(startMoment, that.startMoment) &&
                equal(endMoment, that.endMoment);

    }

    @Override
    public int hashCode() {
        return hash(startMoment, endMoment);

    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return startMoment.isEmpty() &&
                endMoment.isEmpty();
    }

    public boolean contains(TargetYearMonth targetMoment) {

        return (startMoment.isBefore(targetMoment)
                || startMoment.sameMoment(targetMoment))
                && (endMoment.isAfter(targetMoment)
                || endMoment.sameMoment(targetMoment));
    }

    public DefaultYearMonthValue decrementStartMoment() {
        return startMoment.decrementMoment();

    }

    public boolean isContinuous(YearMonthInterval aNextInterval) {
        DefaultYearMonthValue decrementStartNextMoment = aNextInterval.decrementStartMoment();
        return endMoment.sameMoment(decrementStartNextMoment);

    }

    public YearMonthInterval marge(YearMonthInterval aNextInterval) {
        return YearMonthInterval.createFrom(startMoment, aNextInterval.endMoment);

    }

    public boolean isOverlap(YearMonthInterval aNextInterval) {
        return endMoment.isAfter(aNextInterval.startMoment);

    }

    public YearMonthInterval adjustEndMoment(YearMonthInterval aNextInterval) {
        return YearMonthInterval.createFrom(startMoment, aNextInterval.decrementStartMoment());

    }

    private static class DefaultYearMonthValue extends AbstractYearMonthValue<DefaultYearMonthValue> {

        public DefaultYearMonthValue(YearMonth aValue) {
            super(aValue);

        }

        public DefaultYearMonthValue() {
            super();

        }

        public static DefaultYearMonthValue empty() {
            return new DefaultYearMonthValue();

        }

        public static DefaultYearMonthValue of(YearMonthValue<?> aValue) {
            return of(aValue.getValue());

        }

        public static DefaultYearMonthValue of(YearMonth aValue) {
            return new DefaultYearMonthValue(aValue);

        }

        public boolean isAfter(YearMonthValue<?> aTargetMoment) {
            return value.isAfter(aTargetMoment.getValue());

        }

        public boolean sameMoment(YearMonthValue<?> aTargetMoment) {
            return value.equals(aTargetMoment.getValue());

        }

        public boolean isBefore(YearMonthValue<?> aTargetMoment) {
            return value.isBefore(aTargetMoment.getValue());

        }

        public DefaultYearMonthValue decrementMoment() {
            return DefaultYearMonthValue.of(value.minusMonths(1L));

        }

    }
}
