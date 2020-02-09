package org.venuspj.ddd.model.values.primitives.momentinterval;

import org.venuspj.ddd.model.values.primitives.AbstractYearValue;

import java.time.Year;

public class EndYear extends AbstractYearValue<EndYear> implements Moment<Year> {
    public EndYear(Year aValue) {
        super(aValue);
    }

    public static EndYear of(Year aValue) {
        return new EndYear(aValue);

    }

    @Override
    public Comparable<Year> comparable() {
        return value;
    }
}
