package org.venuspj.ddd.model.value;

import java.time.LocalDateTime;

/**
 */
public interface DateTimeValue<T extends DateTimeValue<T>> extends Value<T> {

    LocalDateTime asDateTime();

    LocalDateTime getValue();
}
