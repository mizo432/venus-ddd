package org.venuspj.ddd.model.values.buisiness.datetime;

import java.time.YearMonth;

public class TargetYearMonth extends Moment<YearMonth> {
    public TargetYearMonth(YearMonth aValue) {
        super(aValue);

    }

    public TargetYearMonth() {

    }

    public static TargetYearMonth empty() {
        return new TargetYearMonth();

    }

    public static TargetYearMonth of(YearMonth aValue) {
        return new TargetYearMonth(aValue);

    }

}
