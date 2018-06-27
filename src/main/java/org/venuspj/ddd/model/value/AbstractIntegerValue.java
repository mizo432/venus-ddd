package org.venuspj.ddd.model.value;

import static org.venuspj.util.objects2.Objects2.isNull;

public abstract class AbstractIntegerValue<ASV extends AbstractIntegerValue<ASV>>
        extends AbstractSingleValue<ASV, Integer> implements IntegerValue<ASV> {

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

}
