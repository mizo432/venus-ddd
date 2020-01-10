package org.venuspj.ddd.model.values.primitives;

import java.time.LocalDate;

/**
 * Created by mizoguchi on 2017/02/12.
 */
public interface DateValue<T extends DateValue<T>> extends SingleValue<LocalDate, T> {

    LocalDate asDate();

    LocalDate getValue();

    String asText();
}
