package org.venuspj.ddd.model.values.primitives.momentinterval;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.datetime.TargetYear;
import org.venuspj.ddd.model.values.primitives.AbstractYearValue;
import org.venuspj.ddd.model.values.primitives.YearValue;

import java.time.Year;

import static org.venuspj.util.objects2.Objects2.*;

public class YearInterval implements Value<YearInterval> {

    private DefaultYearValue startMoment = DefaultYearValue.empty();
    private DefaultYearValue endMoment = DefaultYearValue.empty();

    YearInterval(DefaultYearValue aStartMoment, DefaultYearValue anEndMoment) {
        startMoment = aStartMoment;
        endMoment = anEndMoment;

    }

    public YearInterval() {

    }

    public static YearInterval createFrom(YearValue<?> aStartMoment, YearValue<?> anEndMoment) {
        return new YearInterval(DefaultYearValue.of(aStartMoment),
                DefaultYearValue.of(anEndMoment));
    }

    public static YearInterval createFrom(YearValue<?> aStartMoment) {
        return new YearInterval(DefaultYearValue.of(aStartMoment),
                DefaultYearValue.of(DefaultYearValue.MAX));
    }

    public static YearInterval empty() {
        return new YearInterval();
    }

    @Override
    public boolean sameValueAs(YearInterval other) {
        return equals(other);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        YearInterval that = (YearInterval) other;
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

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();
    }

    public boolean contains(TargetYear targetYear) {

        return (startMoment.isBefore(targetYear)
                || startMoment.sameMoment(targetYear))
                && (endMoment.isAfter(targetYear)
                || endMoment.sameMoment(targetYear));
    }

    public DefaultYearValue decrementStartMoment() {
        return startMoment.decrementMoment();

    }

    public YearInterval renewEndDate(DefaultYearValue aEndMoment) {
        return YearInterval.createFrom(startMoment, aEndMoment);

    }

    public boolean isOverlap(YearInterval anInterval) {
        return (startMoment.sameMoment(anInterval.startMoment)) ||
                startMoment.isAfter(anInterval.startMoment) &&
                        (endMoment.isBefore(anInterval.startMoment));

    }

    public boolean isContinuous(YearInterval aNextInterval) {
        DefaultYearValue decrementStartNextMoment = aNextInterval.decrementStartMoment();
        return endMoment.sameMoment(decrementStartNextMoment);

    }

    public YearInterval marge(YearInterval nextInterval) {
        return YearInterval.createFrom(startMoment, nextInterval.endMoment);

    }

    public static class DefaultYearValue extends AbstractYearValue<DefaultYearValue> {

        public static final YearValue<?> MAX = new DefaultYearValue(Year.of(9999));

        DefaultYearValue(Year aValue) {
            super(aValue);

        }

        public DefaultYearValue() {
            super();
        }

        public static DefaultYearValue empty() {
            return new DefaultYearValue();

        }

        public static DefaultYearValue of(YearValue<?> aValue) {
            return of(aValue.getValue());

        }

        public static DefaultYearValue of(Year aValue) {
            return new DefaultYearValue(aValue);

        }

        public boolean isAfter(YearValue<?> targetYear) {
            return value.isAfter(targetYear.getValue());

        }

        public boolean sameMoment(YearValue<?> targetYear) {
            return value.equals(targetYear.getValue());
        }

        public boolean isBefore(YearValue<?> targetYear) {
            return value.isBefore(targetYear.getValue());

        }

        public DefaultYearValue decrementMoment() {
            return DefaultYearValue.of(value.minusYears(1L));
        }
    }
}
