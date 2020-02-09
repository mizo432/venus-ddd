package org.venuspj.ddd.model.values.primitives.momentinterval;

import org.venuspj.ddd.model.values.primitives.AbstractYearValue;

import java.time.Year;

public class StartYear extends AbstractYearValue<StartYear> {
    public StartYear(Year aValue) {
        super(aValue);

    }

    public static StartYear of(Year aValue) {
        return new StartYear(aValue);

    }

}
