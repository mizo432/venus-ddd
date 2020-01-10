package org.venuspj.ddd.model.values;

import org.venuspj.ddd.model.values.primitives.SingleValue;
import org.venuspj.util.collect.ComparisonChain;

import java.time.YearMonth;

public class AbstractComparableSingleValue<T extends Comparable<T>, ACSV extends AbstractComparableSingleValue<T, ACSV>> extends AbstractSingleValue<T, ACSV> {

    protected AbstractComparableSingleValue() {

    }

    protected AbstractComparableSingleValue(T value) {
        super(value);

    }

    @Override
    public int compareTo(ACSV o) {
        return ComparisonChain
                .start()
                .compare(value, o.value)
                .result();
    }

    /**
     * Created by mizoguchi on 2017/02/14.
     */
    public static interface YearMonthValue<T extends YearMonthValue<T>> extends SingleValue<YearMonth, T> {

        YearMonth asYearMonth();

        String asText();

        YearMonth getValue();
    }
}
