package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.primitives.AbstractDateValue;

import java.time.LocalDate;

public class TargetDate extends AbstractDateValue<TargetDate> {

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
