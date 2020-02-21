package org.venuspj.ddd.model.values.buisiness.datetime;

import java.time.Year;

public class TargetYear extends Moment<Year> {

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
