package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractComparableSingleValue;

import static org.venuspj.util.objects2.Objects2.isNull;
import static org.venuspj.util.objects2.Objects2.nonNull;

public abstract class AbstractIntegerValue<AIV extends AbstractIntegerValue<AIV>>
        extends AbstractComparableSingleValue<Integer, AIV> implements IntegerValue<AIV> {

    protected AbstractIntegerValue() {
        super();
    }

    protected AbstractIntegerValue(Integer value) {
        super(value);

    }

    @Override
    public Integer asInteger() {
        return value;

    }

    @Override
    public String asText() {
        if (isNull(value)) return null;
        return value.toString();
    }

    public boolean isEmpty() {
        return isNull(value);

    }

    public boolean isPresent() {
        return nonNull(value);

    }

    public boolean isZero() {
        return 0 == value;
    }

    public boolean isNegative() {
        return 0 > value;
    }

    public boolean isPositive() {
        return 0 < value;
    }

}
