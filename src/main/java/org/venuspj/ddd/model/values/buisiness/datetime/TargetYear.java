package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.primitives.AbstractYearValue;
import org.venuspj.ddd.model.values.primitives.momentinterval.Moment;

import java.time.Year;

public class TargetYear extends AbstractYearValue<TargetYear> implements Moment<TargetYear> {
    public TargetYear(Year aValue) {
        super(aValue);
    }

    public TargetYear() {

    }

    public static TargetYear empty() {
        return new TargetYear();

    }

    public static TargetYear of(Year aValue) {
        return new TargetYear(aValue);

    }

}
