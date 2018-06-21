package org.venuspj.ddd.model.value;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.hash;

public class AbstractYearMonthValue<AYMV extends AbstractYearMonthValue<AYMV>>
        extends AbstractSingleValue<AYMV, YearMonth> implements YearMonthValue<AYMV> {

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
