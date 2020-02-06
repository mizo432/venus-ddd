package org.venuspj.ddd.model.values.buisiness.quantity;

import org.venuspj.ddd.model.values.primitives.AbstractBigDecimalValue;

import java.math.BigDecimal;

public class QuantityDecimal extends AbstractBigDecimalValue<QuantityDecimal> {

    public QuantityDecimal(BigDecimal aValue) {
        super(aValue);

    }

    public QuantityDecimal() {
        super();
    }

    public static QuantityDecimal of(BigDecimal aValue) {
        return new QuantityDecimal(aValue);

    }

    public static QuantityDecimal empty() {
        return new QuantityDecimal();
    }
}
