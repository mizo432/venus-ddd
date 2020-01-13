package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractComparableSingleValue;

import static org.venuspj.util.objects2.Objects2.isNull;

public abstract class AbstractLongValue<ASV extends AbstractLongValue<ASV>>
        extends AbstractComparableSingleValue<Long, ASV> implements LongSingleValue<ASV> {

    protected AbstractLongValue() {
    }

    protected AbstractLongValue(Long value) {
        super(value);

    }

    @Override
    public Long asLong() {
        return value;

    }

    @Override
    public String asText() {
        if(isNull(value)) return null;
        return value.toString();

    }

}
