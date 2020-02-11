package org.venuspj.ddd.model.values.primitives.momentinterval;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.ddd.model.values.buisiness.datetime.TargetDate;
import org.venuspj.ddd.model.values.primitives.AbstractDateValue;
import org.venuspj.ddd.model.values.primitives.DateValue;

import java.time.LocalDate;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.hash;

public class DateInterval extends AbstractValue<DateInterval> {
    private DefaultDateValue startMoment = DefaultDateValue.empty();
    private DefaultDateValue endMoment = DefaultDateValue.empty();

    DateInterval(DefaultDateValue aStartMoment, DefaultDateValue anEndMoment) {
        startMoment = aStartMoment;
        endMoment = anEndMoment;

    }

    public static DateInterval createFrom(DateValue<?> aStartMoment, DateValue<?> anEndMoment) {
        return new DateInterval(DefaultDateValue.of(aStartMoment),
                DefaultDateValue.of(anEndMoment));
    }

    @Override
    public boolean sameValueAs(DateInterval other) {
        return equals(other);

    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        DateInterval that = (DateInterval) other;
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

    public boolean contains(TargetDate targetMoment) {
        return (startMoment.isBefore(targetMoment)
                || startMoment.sameMoment(targetMoment))
                && (endMoment.isAfter(targetMoment)
                || endMoment.sameMoment(targetMoment));

    }

    public DefaultDateValue decrementStartMoment() {
        return startMoment.decrementMoment();

    }

    public boolean isContinuous(DateInterval aNextInterval) {
        DefaultDateValue decrementStartNextMoment = aNextInterval.decrementStartMoment();
        return endMoment.sameMoment(decrementStartNextMoment);

    }

    public DateInterval marge(DateInterval aNextInterval) {
        return DateInterval.createFrom(startMoment, aNextInterval.endMoment);

    }

    public boolean isOverlap(DateInterval aNextInterval) {
        return endMoment.isAfter(aNextInterval.startMoment);

    }

    public DateInterval adjustEndMoment(DateInterval aNextInterval) {
        return DateInterval.createFrom(startMoment, aNextInterval.decrementStartMoment());

    }

    private static class DefaultDateValue extends AbstractDateValue<DefaultDateValue> {

        public DefaultDateValue(LocalDate aValue) {
            super(aValue);

        }

        public DefaultDateValue() {
            super();
        }

        public static DefaultDateValue empty() {
            return new DefaultDateValue();

        }

        public static DefaultDateValue of(DateValue<?> aValue) {
            return of(aValue.getValue());

        }

        public boolean isAfter(DateValue<?> aTargetMoment) {
            return value.isAfter(aTargetMoment.getValue());

        }

        public boolean sameMoment(DateValue<?> aTargetMoment) {
            return value.equals(aTargetMoment.getValue());

        }


        public boolean isBefore(DateValue<?> aTargetMoment) {
            return value.isBefore(aTargetMoment.getValue());

        }

        public DefaultDateValue decrementMoment() {
            return DefaultDateValue.of(value.minusDays(1L));
        }

        private static DefaultDateValue of(LocalDate aValue) {
            return new DefaultDateValue(aValue);
        }
    }
}
