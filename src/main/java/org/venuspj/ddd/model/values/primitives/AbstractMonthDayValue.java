package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractComparableSingleValue;

import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

public class AbstractMonthDayValue<AYMV extends AbstractMonthDayValue<AYMV>>
        extends AbstractComparableSingleValue<MonthDay, AYMV> implements MonthDayValue<AYMV> {

    protected AbstractMonthDayValue() {
    }

    protected AbstractMonthDayValue(MonthDay value) {
        super(value);

    }

    @Override
    public MonthDay asYearMonth() {
        return MonthDay.from(value);

    }

    @Override
    public String asText() {
        return value.format(DateTimeFormatter.ofPattern("MM-dd"));

    }

}
