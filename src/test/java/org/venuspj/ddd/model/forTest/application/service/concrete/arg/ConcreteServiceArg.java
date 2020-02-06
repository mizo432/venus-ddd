package org.venuspj.ddd.model.forTest.application.service.concrete.arg;

import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityIdentifier;

public class ConcreteServiceArg {
    ConcreteEntityIdentifier concreteEntityIdentifier = ConcreteEntityIdentifier.empty();

    public void setConcreteEntityIdentifier(Long aValue) {
        concreteEntityIdentifier = ConcreteEntityIdentifier.of(aValue);

    }

    public ConcreteEntityIdentifier getConcreteEntityIdentifire() {
        return concreteEntityIdentifier;
    }
}
