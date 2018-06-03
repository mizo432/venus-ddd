package org.venuspj.ddd.model.value;

import java.time.YearMonth;

/**
 * Created by mizoguchi on 2017/02/14.
 */
public interface YearMonthValue<T extends YearMonthValue<T>> extends Value<T> {
    YearMonth asYearMonth();
    String asText();
}
