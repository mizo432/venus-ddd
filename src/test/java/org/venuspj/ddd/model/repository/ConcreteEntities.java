package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.AbstractEntityTest.ConcreteEntity;
import org.venuspj.ddd.model.value.AbstractListValue;

import java.util.Collection;

public class ConcreteEntities extends AbstractListValue<ConcreteEntity> {

    public ConcreteEntities(Collection<ConcreteEntity> concreteEntitys) {
        super(concreteEntitys);

    }

    public static ConcreteEntities of(Collection<ConcreteEntity> concreteEntities) {
        return new ConcreteEntities(concreteEntities);

    }
}