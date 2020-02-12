package org.venuspj.ddd.model.values.primitives.momentinterval;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.ddd.model.values.buisiness.datetime.TargetDateTime;
import org.venuspj.ddd.model.values.primitives.AbstractDateTimeValue;
import org.venuspj.ddd.model.values.primitives.DateTimeValue;

import java.time.LocalDateTime;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.hash;

public class DateTimeInterval extends AbstractValue<DateTimeInterval> {
    private DefaultDateTimeValue startMoment = DefaultDateTimeValue.empty();
    private DefaultDateTimeValue endMoment = DefaultDateTimeValue.empty();

    DateTimeInterval(DefaultDateTimeValue aStartMoment, DefaultDateTimeValue anEndMoment) {
        startMoment = aStartMoment;
        endMoment = anEndMoment;

    }

    public static DateTimeInterval createFrom(DateTimeValue<?> aStartMoment, DateTimeValue<?> anEndMoment) {
        return new DateTimeInterval(DefaultDateTimeValue.of(aStartMoment),
                DefaultDateTimeValue.of(anEndMoment));
    }

    @Override
    public boolean sameValueAs(DateTimeInterval other) {
        return equals(other);

    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        DateTimeInterval that = (DateTimeInterval) other;
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

    public boolean contains(TargetDateTime targetMoment) {

        return (startMoment.isBefore(targetMoment)
                || startMoment.sameMoment(targetMoment))
                && (endMoment.isAfter(targetMoment)
                || endMoment.sameMoment(targetMoment));
    }

    public DefaultDateTimeValue decrementStartMoment() {
        return startMoment.decrementMoment();

    }

    public boolean isContinuous(DateTimeInterval aNextInterval) {
        DefaultDateTimeValue decrementStartNextMoment = aNextInterval.decrementStartMoment();
        return endMoment.sameMoment(decrementStartNextMoment);

    }

    public DateTimeInterval marge(DateTimeInterval aNextInterval) {
        return DateTimeInterval.createFrom(startMoment, aNextInterval.endMoment);

    }

    public DateTimeInterval adjustEndDate(DateTimeInterval aNextInterval) {
        return DateTimeInterval.createFrom(startMoment, aNextInterval.decrementStartMoment());

    }

    public boolean isOverlap(DateTimeInterval aNextInterval) {
        return endMoment.isAfter(aNextInterval.startMoment);

    }

    private static class DefaultDateTimeValue extends AbstractDateTimeValue<DefaultDateTimeValue> {

        public DefaultDateTimeValue(LocalDateTime aValue) {
            super(aValue);

        }

        public DefaultDateTimeValue() {
            super();
        }

        public static DefaultDateTimeValue empty() {
            return new DefaultDateTimeValue();

        }

        public static DefaultDateTimeValue of(DateTimeValue<?> aValue) {
            return of(aValue.getValue());

        }

        public boolean isAfter(DateTimeValue<?> aTargetMoment) {
            return value.isAfter(aTargetMoment.getValue());

        }

        public boolean sameMoment(DateTimeValue<?> aTargetMoment) {
            return value.equals(aTargetMoment.getValue());

        }


        public boolean isBefore(DateTimeValue<?> aTargetMoment) {
            return value.isBefore(aTargetMoment.getValue());

        }

        public DefaultDateTimeValue decrementMoment() {
            return DefaultDateTimeValue.of(value.minusNanos(1L));

        }

        private static DefaultDateTimeValue of(LocalDateTime aValue) {
            return new DefaultDateTimeValue(aValue);

        }
    }
}
