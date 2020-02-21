package org.venuspj.ddd.model.values.buisiness.datetime;

import java.time.LocalDateTime;

public class TargetDateTime extends Moment<LocalDateTime> {

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
