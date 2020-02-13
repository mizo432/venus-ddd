package org.venuspj.basic.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public abstract class PartyIdentifier<I extends PartyIdentifier<I>> extends AbstractEntityLongIdentifier<I> {

    protected PartyIdentifier(Class<?> entityClass, Long aValue) {
        super(entityClass, aValue);
    }

    protected PartyIdentifier(Class<?> entityClass) {
        super(entityClass);
    }
}
