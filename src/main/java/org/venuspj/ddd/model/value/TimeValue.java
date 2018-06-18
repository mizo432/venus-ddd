package org.venuspj.ddd.model.value;

import java.time.LocalTime;

/**
 * Created by mizoguchi on 2017/02/14.
 */
public interface TimeValue<T extends TimeValue<T>> extends Value<T> {
    LocalTime asTime();

    String asText();

    LocalTime getValue();
}
