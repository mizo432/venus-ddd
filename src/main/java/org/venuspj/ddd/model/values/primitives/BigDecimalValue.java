package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

import java.math.BigDecimal;

public interface BigDecimalValue<ISV extends BigDecimalValue<ISV>> extends SingleValue<BigDecimal, ISV> {

    BigDecimal asBigDecimal();

    String asText();

    BigDecimal getValue();

}
