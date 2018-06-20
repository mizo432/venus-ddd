package org.venuspj.ddd.model.entity;


import org.venuspj.ddd.model.value.LongValue;

import static org.venuspj.util.objects2.Objects2.equal;

/**
 * Created by mizoguchi on 2017/07/01.
 */
public abstract class AbstractLongEntityIdentifier<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI, Long>>
        extends AbstractEntityIdentifier<E, EI, Long>
        implements LongIdentifierValue<E, EI> {

    public AbstractLongEntityIdentifier(Class<E> clazz) {
        super(clazz);

    }

    protected AbstractLongEntityIdentifier(Class<E> clazz, Long value) {
        super(clazz, value);

    }

    public Long asLong() {
        return value;
    }

    public String asText() {
        return value.toString();
    }


}
