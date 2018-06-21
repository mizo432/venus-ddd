package org.venuspj.ddd.model.value;

import static org.venuspj.util.objects2.Objects2.equal;

public class AbstractIntegerValue<ASV extends AbstractIntegerValue<ASV>>
        extends AbstractSingleValue<ASV, Integer> implements IntegerValue<ASV> {

    protected AbstractIntegerValue() {
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
        return value.toString();
    }

}
