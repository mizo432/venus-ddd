package org.venuspj.ddd.model.values.primitives.momentinterval;

public interface Interval<M extends Moment> {
    M getStartMoment();

    M getEndMoment();
}
