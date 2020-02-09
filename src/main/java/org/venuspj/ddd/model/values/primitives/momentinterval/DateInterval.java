package org.venuspj.ddd.model.values.primitives.momentinterval;

import org.venuspj.ddd.model.values.Value;

public interface DateInterval<M extends Moment> extends Value<DateInterval<M>> {

    M startMoment();

    M endMoment();
}
