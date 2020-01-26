package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.AbstractEntityIdentifierTest;

public class ConcreteServiceArg {
    AbstractEntityIdentifierTest.ConcreteEntityIdentifier concreteEntityIdentifier = AbstractEntityIdentifierTest.ConcreteEntityIdentifier.empty();

    public void setConcreteEntityIdentifier(Long aValue) {
        concreteEntityIdentifier = AbstractEntityIdentifierTest.ConcreteEntityIdentifier.of(aValue);

    }

    public AbstractEntityIdentifierTest.ConcreteEntityIdentifier getConcreteEntityIdentifire() {
        return concreteEntityIdentifier;
    }
}
