package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractComparableSingleValue;

public class AbstractBooleanValue<ABV extends AbstractBooleanValue<ABV>> extends AbstractComparableSingleValue<Boolean, ABV> implements BooleanValue<ABV> {

    protected AbstractBooleanValue() {
    }

    protected AbstractBooleanValue(Boolean value) {
        super(value);

    }


    @Override
    public String asText() {
        return value.toString();
    }

    @Override
    public Boolean asBoolean() {
        return value;

    }

}
