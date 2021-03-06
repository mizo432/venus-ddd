package org.venuspj.ddd.model.forTest.application.service.concrete.result;

import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntity;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityIdentifier;

public class ConcreteServiceResult {
    private ConcreteEntity entity;

    public void setConcreteEntity(ConcreteEntity anEntity) {
        entity = anEntity;

    }

    public ConcreteEntityIdentifier getIdentifier() {
        return entity.getIdentifier();
    }
}
