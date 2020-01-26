package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.ConcreteEntityIdentifier;

public class ConcreteServiceArg {
    ConcreteEntityIdentifier concreteEntityIdentifier = ConcreteEntityIdentifier.empty();

    public void setConcreteEntityIdentifier(Long aValue) {
        concreteEntityIdentifier = ConcreteEntityIdentifier.of(aValue);

    }

    public ConcreteEntityIdentifier getConcreteEntityIdentifire() {
        return concreteEntityIdentifier;
    }
}
