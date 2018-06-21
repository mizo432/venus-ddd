package org.venuspj.ddd.model.value;

import static org.venuspj.util.objects2.Objects2.equal;

public class AbstractLongValue<ASV extends AbstractLongValue<ASV>>
        extends AbstractSingleValue<ASV, Long> implements LongValue<ASV> {

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
        return value.toString();
    }

}
