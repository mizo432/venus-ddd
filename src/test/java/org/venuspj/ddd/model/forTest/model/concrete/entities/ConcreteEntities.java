package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.entity.AbstractEntities;

import java.util.Collection;
import java.util.function.Predicate;

public class ConcreteEntities extends AbstractEntities<ConcreteEntity, ConcreteEntityIdentifier, ConcreteEntities> {

    public ConcreteEntities(Collection<ConcreteEntity> concreteEntities) {
        super(concreteEntities);

    }

    public ConcreteEntities() {

    }

    public static ConcreteEntities of(Collection<ConcreteEntity> concreteEntities) {
        return new ConcreteEntities(concreteEntities);

    }

    public static ConcreteEntities empty() {
        return new ConcreteEntities();
    }


    public ConcreteEntities selectEntityBy(Predicate<ConcreteEntity> aPredicate) {
        return ConcreteEntities.of(super.selectBy(aPredicate));
    }
}
