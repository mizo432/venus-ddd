package org.venuspj.ddd.model.values.primitives.momentinterval;

import org.venuspj.ddd.model.values.primitives.AbstractYearMonthValue;

import java.time.YearMonth;

public class StartYearMonth extends AbstractYearMonthValue<StartYearMonth> {
    public StartYearMonth(YearMonth aValue) {
        super(aValue);
    }

    public static StartYearMonth of(YearMonth aValue) {
        return new StartYearMonth(aValue);
    }
}
