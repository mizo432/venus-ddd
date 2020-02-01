package org.venuspj.ddd.model.forTest.model.concrete;

import org.venuspj.ddd.model.entity.AbstractEntities;

import java.util.Collection;

public class ConcreteEntities extends AbstractEntities<ConcreteEntity, ConcreteEntityIdentifier, ConcreteEntities> {

    public ConcreteEntities(Collection<ConcreteEntity> concreteEntities) {
        super(concreteEntities);

    }

    public static ConcreteEntities of(Collection<ConcreteEntity> concreteEntities) {
        return new ConcreteEntities(concreteEntities);

    }


}
