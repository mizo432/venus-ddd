package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.ConcreteEntity;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.util.Collection;

public class ConcreteEntities extends AbstractListValue<ConcreteEntity, ConcreteEntities> {

    public ConcreteEntities(Collection<ConcreteEntity> concreteEntities) {
        super(concreteEntities);

    }

    public static ConcreteEntities of(Collection<ConcreteEntity> concreteEntities) {
        return new ConcreteEntities(concreteEntities);

    }
}
