package org.venuspj.ddd.model.values.primitives.momentinterval;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.datetime.TargetYearMonth;
import org.venuspj.ddd.model.values.primitives.AbstractYearMonthValue;
import org.venuspj.ddd.model.values.primitives.YearMonthValue;

import java.time.YearMonth;

import static org.venuspj.util.objects2.Objects2.*;

public class YearMonthInterval implements Value<YearMonthInterval> {
    private DefaultYearMonthValue startMoment = DefaultYearMonthValue.empty();
    private DefaultYearMonthValue endMoment = DefaultYearMonthValue.empty();

    YearMonthInterval(DefaultYearMonthValue aStartMoment, DefaultYearMonthValue anEndMoment) {
        startMoment = aStartMoment;
        endMoment = anEndMoment;

    }

    public static YearMonthInterval createFrom(YearMonthValue<?> aStartMoment, YearMonthValue<?> anEndMoment) {
        return new YearMonthInterval(DefaultYearMonthValue.of(aStartMoment),
                DefaultYearMonthValue.of(anEndMoment));
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

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();
    }

    public boolean contains(TargetYearMonth targetMoment) {

        return (startMoment.isBefore(targetMoment)
                || startMoment.sameMoment(targetMoment))
                && (endMoment.isAfter(targetMoment)
                || endMoment.sameMoment(targetMoment));
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
            return new DefaultYearMonthValue(aValue.getValue());

        }

        public boolean isAfter(TargetYearMonth aTargetMoment) {
            return value.isAfter(aTargetMoment.getValue());

        }

        public boolean sameMoment(TargetYearMonth aTargetMoment) {
            return value.equals(aTargetMoment.getValue());
        }

        public boolean isBefore(TargetYearMonth aTargetMoment) {
            return value.isBefore(aTargetMoment.getValue());

        }
    }
}
