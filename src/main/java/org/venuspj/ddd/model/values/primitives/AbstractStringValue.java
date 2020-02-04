package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractComparableSingleValue;
import org.venuspj.util.strings2.Strings2;

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

    @Override
    public boolean isEmpty() {
        return super.isEmpty()
                || Strings2.isEmpty(value);

    }
}
