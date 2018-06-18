package org.venuspj.ddd.model.entity;


import org.venuspj.ddd.model.value.LongValue;

import static org.venuspj.util.objects2.Objects2.equal;

/**
 * Created by mizoguchi on 2017/07/01.
 */
public abstract class AbstractLongIdentifierValue<ALIV extends AbstractLongIdentifierValue<ALIV>> implements LongValue<ALIV> {
    protected Long value;

    public AbstractLongIdentifierValue() {

    }

    protected AbstractLongIdentifierValue(Long value) {
        this.value = value;

    }

    @Override
    public Long asLong() {
        return value;
    }

    @Override
    public String asText() {
        return value.toString();
    }

    @Override
    public boolean sameValueAs(ALIV other) {
        return equal(value, other.asLong());
    }

}
