package org.venuspj.ddd.model.values.primitives.momentinterval;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.datetime.TargetDate;
import org.venuspj.ddd.model.values.primitives.AbstractDateValue;
import org.venuspj.ddd.model.values.primitives.DateValue;

import java.time.LocalDate;

import static org.venuspj.util.objects2.Objects2.*;

public class DateInterval implements Value<DateInterval> {
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

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();
    }

    public boolean contains(TargetDate targetMoment) {

        return (startMoment.isBefore(targetMoment)
                || startMoment.sameMoment(targetMoment))
                && (endMoment.isAfter(targetMoment)
                || endMoment.sameMoment(targetMoment));
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
            return new DefaultDateValue(aValue.getValue());

        }

        public boolean isAfter(TargetDate aTargetMoment) {
            return value.isAfter(aTargetMoment.getValue());

        }

        public boolean sameMoment(TargetDate aTargetMoment) {
            return value.equals(aTargetMoment.getValue());
        }


        public boolean isBefore(TargetDate aTargetMoment) {
            return value.isBefore(aTargetMoment.getValue());

        }
    }
}
