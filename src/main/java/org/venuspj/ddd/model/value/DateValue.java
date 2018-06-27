package org.venuspj.ddd.model.value;

import java.time.LocalDate;

/**
 * Created by mizoguchi on 2017/02/12.
 */
public interface DateValue<T extends DateValue<T>> extends Value<T> {
    LocalDate asDate();

    LocalDate getValue();

    String asText();
}
