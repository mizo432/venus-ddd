package org.venuspj.ddd.model.values.buisiness.rate;

import org.venuspj.ddd.model.values.buisiness.percentage.Percentage;
import org.venuspj.ddd.model.values.primitives.AbstractBigDecimalValue;

import java.math.BigDecimal;

/**
 * 率.
 */
public class Rate extends AbstractBigDecimalValue<Rate> {
    protected Rate(BigDecimal aValue) {
        super(aValue);

    }

    public static Rate zero() {
        return valueOf(BigDecimal.ZERO);

    }

    public static Rate sum(Rate... anyRates) {
        BigDecimal result = BigDecimal.ZERO;
        for (Rate aRate : anyRates) {
            result = result.add(aRate.value);
        }
        return Rate.valueOf(result);

    }

    public static Rate valueOf(BigDecimal aValue) {
        return new Rate(aValue);

    }

    public static Rate all() {
        return new Rate(BigDecimal.valueOf(1));

    }

    public Percentage toPercentage() {
        return Percentage.valueOf(value.multiply(BigDecimal.valueOf(100)));

    }

}
