package org.venuspj.ddd.model.values.buisiness;

import org.venuspj.ddd.model.values.primitives.AbstractBigDecimalValue;

import java.math.BigDecimal;

public class Percentage extends AbstractBigDecimalValue<Percentage> {

    protected Percentage(BigDecimal aValue) {
        super(aValue);

    }

    public static Percentage zero() {
        return valueOf(BigDecimal.ZERO);

    }

    public static Percentage sum(Percentage... anyPercentages) {
        BigDecimal result = BigDecimal.ZERO;
        for (Percentage aPercentage : anyPercentages) {
            result = result.add(aPercentage.value);
        }
        return Percentage.valueOf(result);

    }

    public static Percentage valueOf(BigDecimal aValue) {
        return new Percentage(aValue);

    }

    public static Percentage all() {
        return new Percentage(BigDecimal.valueOf(100));

    }

    @Override
    public String asText() {
        return getValue().toString() + "%";

    }

}
