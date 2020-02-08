package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.primitives.AbstractYearMonthValue;
import org.venuspj.ddd.model.values.primitives.momentinterval.Moment;

import java.time.YearMonth;

public class TargetYearMonth extends AbstractYearMonthValue<TargetYearMonth> implements Moment<TargetYearMonth> {
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
