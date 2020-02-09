package org.venuspj.ddd.model.values.primitives.momentinterval;

import org.venuspj.ddd.model.values.primitives.AbstractYearMonthValue;

import java.time.YearMonth;

public class EndYearMonth extends AbstractYearMonthValue<EndYearMonth> {
    public EndYearMonth(YearMonth aValue) {
        super(aValue);
    }

    public static EndYearMonth of(YearMonth aValue) {
        return new EndYearMonth(aValue);
    }
}
