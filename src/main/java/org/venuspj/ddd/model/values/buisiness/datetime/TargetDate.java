package org.venuspj.ddd.model.values.buisiness.datetime;

import java.time.LocalDate;

public class TargetDate extends Moment<LocalDate> {

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
