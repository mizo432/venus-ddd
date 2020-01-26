package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.AbstractEntityIdentifierTest;
import org.venuspj.ddd.model.entity.AbstractEntityTest;

public class ConcreteServiceResult {
    private AbstractEntityTest.ConcreteEntity entity;

    public void setConcreteEntity(AbstractEntityTest.ConcreteEntity anEntity) {
        entity = anEntity;

    }

    public AbstractEntityIdentifierTest.ConcreteEntityIdentifier getIdentifier() {
        return entity.getIdentifier();
    }
}
