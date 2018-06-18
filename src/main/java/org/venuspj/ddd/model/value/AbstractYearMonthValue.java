package org.venuspj.ddd.model.value;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

import static org.venuspj.util.objects2.Objects2.equal;

public class AbstractYearMonthValue<AYMV extends AbstractYearMonthValue<AYMV>> implements YearMonthValue<AYMV> {
    protected YearMonth value;

    public AbstractYearMonthValue() {
    }

    protected AbstractYearMonthValue(YearMonth value) {
        this.value = value;

    }

    @Override
    public YearMonth asYearMonth() {
        return YearMonth.from(value);
    }

    @Override
    public String asText() {
        return value.format(DateTimeFormatter.ofPattern("uuuu-MM"));

    }

    @Override
    public YearMonth getValue() {
        return value;

    }

    @Override
    public boolean sameValueAs(AYMV other) {
        return equal(value, other.value);

    }
}
