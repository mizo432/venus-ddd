package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

import java.time.LocalDateTime;

/**
 *
 */
public interface DateTimeValue<T extends DateTimeValue<T>> extends SingleValue<LocalDateTime, T> {

    LocalDateTime asDateTime();

    LocalDateTime getValue();
}
