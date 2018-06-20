package org.venuspj.ddd.model.entity;


/**
 * Created by mizoguchi on 2017/07/01.
 */
public abstract class AbstractIntegerEntityIdentifier<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI, Integer>>
        extends AbstractEntityIdentifier<E, EI, Integer>
        implements IntegerIdentifierValue<E, EI> {

    public AbstractIntegerEntityIdentifier(Class<E> clazz) {
        super(clazz);

    }

    protected AbstractIntegerEntityIdentifier(Class<E> clazz, Integer value) {
        super(clazz, value);

    }

    public Integer asInteger() {
        return value;
    }

    public String asText() {
        return value.toString();
    }


}
