package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.primitives.AbstractDateTimeValue;
import org.venuspj.ddd.model.values.primitives.momentinterval.Moment;

import java.time.LocalDateTime;

public class TargetDateTime extends AbstractDateTimeValue<TargetDateTime> implements Moment<TargetDateTime> {
    public TargetDateTime(LocalDateTime aValue) {
        super(aValue);
    }

    public TargetDateTime() {

    }

    public static TargetDateTime of(LocalDateTime aValue) {
        return new TargetDateTime(aValue);
    }

    public static TargetDateTime empty() {
        return new TargetDateTime();

    }
}
