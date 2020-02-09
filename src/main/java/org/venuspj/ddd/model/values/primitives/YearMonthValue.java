package org.venuspj.ddd.model.values.primitives;

import java.time.YearMonth;

/**
 * Created by mizoguchi on 2017/02/14.
 */
public interface YearMonthValue<T extends YearMonthValue<T>> extends SingleValue<YearMonth, T> {

    YearMonth asYearMonth();

    String asText();

    YearMonth getValue();
}
