package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractComparableSingleValue;

import java.math.BigDecimal;

public class AbstractBigDecimalValue<ABIV extends AbstractBigDecimalValue<ABIV>> extends AbstractComparableSingleValue<BigDecimal, ABIV> implements BigDecimalValue<ABIV> {
    protected AbstractBigDecimalValue() {

    }

    protected AbstractBigDecimalValue(BigDecimal value) {
        super(value);

    }


    @Override
    public String asText() {
        return value.toString();

    }

    @Override
    public BigDecimal asBigDecimal() {
        return value;

    }

}
