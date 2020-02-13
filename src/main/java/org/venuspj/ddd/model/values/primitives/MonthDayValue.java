package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

import java.time.MonthDay;

/**
 * Created by mizoguchi on 2017/02/14.
 */
public interface MonthDayValue<T extends MonthDayValue<T>> extends SingleValue<MonthDay, T> {

    MonthDay asYearMonth();

    String asText();

    MonthDay getValue();

}
