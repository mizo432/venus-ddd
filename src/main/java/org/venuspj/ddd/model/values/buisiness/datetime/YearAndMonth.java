package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.primitives.AbstractYearMonthValue;

import java.time.YearMonth;

public class YearAndMonth extends AbstractYearMonthValue<YearAndMonth> {

    public YearAndMonth(String aYearMonth) {
        super(YearMonth.parse(aYearMonth));

    }

    protected YearAndMonth(YearMonth aYearMonth) {
        super(aYearMonth);

    }

    public static YearAndMonth of(YearMonth aYearMonth) {
        return new YearAndMonth(aYearMonth);

    }

}
