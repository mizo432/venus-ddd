package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

import java.math.BigInteger;

public interface BigIntegerValue<ISV extends BigIntegerValue<ISV>> extends SingleValue<BigInteger, ISV> {

    BigInteger asBigInteger();

    String asText();

    BigInteger getValue();

}
