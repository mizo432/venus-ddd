package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractComparableSingleValue;

public abstract class AbstractStringValue<ASV extends AbstractStringValue<ASV>>
        extends AbstractComparableSingleValue<String, ASV> implements StringValue<ASV> {

    protected AbstractStringValue() {
    }

    protected AbstractStringValue(String value) {
        super(value);

    }

    @Override
    public String asText() {
        return value;
    }

    @Override
    public String getValue() {
        return value;
    }

}
