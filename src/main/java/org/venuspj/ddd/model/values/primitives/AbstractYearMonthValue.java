package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractComparableSingleValue;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

public class AbstractYearMonthValue<AYMV extends AbstractYearMonthValue<AYMV>>
        extends AbstractComparableSingleValue<YearMonth, AYMV> implements AbstractComparableSingleValue.YearMonthValue<AYMV> {

    protected AbstractYearMonthValue() {
    }

    protected AbstractYearMonthValue(YearMonth value) {
        super(value);

    }

    @Override
    public YearMonth asYearMonth() {
        return YearMonth.from(value);

    }

    @Override
    public String asText() {
        return value.format(DateTimeFormatter.ofPattern("uuuu-MM"));

    }

}
