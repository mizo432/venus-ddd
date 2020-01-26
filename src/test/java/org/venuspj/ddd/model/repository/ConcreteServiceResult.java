package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.ConcreteEntity;
import org.venuspj.ddd.model.entity.ConcreteEntityIdentifier;

public class ConcreteServiceResult {
    private ConcreteEntity entity;

    public void setConcreteEntity(ConcreteEntity anEntity) {
        entity = anEntity;

    }

    public ConcreteEntityIdentifier getIdentifier() {
        return entity.getIdentifier();
    }
}
