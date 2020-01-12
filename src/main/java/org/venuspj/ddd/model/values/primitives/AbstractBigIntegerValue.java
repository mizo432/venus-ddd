package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractComparableSingleValue;

import java.math.BigInteger;

public class AbstractBigIntegerValue<ABIV extends AbstractBigIntegerValue<ABIV>> extends AbstractComparableSingleValue<BigInteger, ABIV> implements BigIntegerValue<ABIV> {
    protected AbstractBigIntegerValue() {

    }

    protected AbstractBigIntegerValue(BigInteger value) {
        super(value);

    }


    @Override
    public String asText() {
        return value.toString();

    }

    @Override
    public BigInteger asBigInteger() {
        return value;

    }

}
