package org.venuspj.ddd.model.entity;


/**
 * Created by mizoguchi on 2017/07/01.
 */
public abstract class AbstractIntegerEntityIdentifier<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI, Integer>>
        extends AbstractEntityIdentifier<E, EI, Integer>
        implements IntegerIdentifierValue<E, EI> {

    public AbstractIntegerEntityIdentifier() {

    }

    protected AbstractIntegerEntityIdentifier(Integer value) {
        this.value = value;

    }

    public Integer asInteger() {
        return value;
    }

    public String asText() {
        return value.toString();
    }


}
