package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

import java.time.LocalTime;

/**
 * Created by mizoguchi on 2017/02/14.
 */
public interface TimeValue<T extends TimeValue<T>> extends SingleValue<LocalTime, T> {

    LocalTime asTime();

    String asText();

    LocalTime getValue();
}
