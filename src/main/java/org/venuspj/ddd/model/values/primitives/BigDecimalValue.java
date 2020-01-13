package org.venuspj.ddd.model.values.primitives;

import java.math.BigDecimal;

public interface BigDecimalValue<ISV extends BigDecimalValue<ISV>> extends SingleValue<BigDecimal, ISV> {

    BigDecimal asBigDecimal();

    String asText();

    BigDecimal getValue();

}
