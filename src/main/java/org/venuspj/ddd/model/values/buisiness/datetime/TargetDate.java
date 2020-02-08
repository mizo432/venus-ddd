package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.primitives.AbstractDateValue;
import org.venuspj.ddd.model.values.primitives.momentinterval.Moment;

import java.time.LocalDate;

public class TargetDate extends AbstractDateValue<TargetDate> implements Moment<TargetDate> {

    TargetDate(LocalDate aValue) {
        super(aValue);
    }

    public TargetDate() {

    }

    public static TargetDate of(LocalDate aValue) {
        return new TargetDate(aValue);
    }

    public static TargetDate empty() {
        return new TargetDate();

    }
}
