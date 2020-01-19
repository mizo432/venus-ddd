package org.venuspj.ddd.model.values.buisiness.quantity;

import org.venuspj.ddd.model.values.primitives.AbstractBigDecimalValue;

import java.math.BigDecimal;

public class Quantity extends AbstractBigDecimalValue<Quantity> {

    public Quantity(BigDecimal aValue) {
        super(aValue);

    }

    public static Quantity of(BigDecimal aValue) {
        return new Quantity(aValue);

    }

}
