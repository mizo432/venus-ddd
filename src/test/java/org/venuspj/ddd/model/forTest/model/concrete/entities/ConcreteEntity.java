package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.entity.AbstractEntity;

public class ConcreteEntity extends AbstractEntity<ConcreteEntity, ConcreteEntityIdentifier> {
    ConcreteInfo concreteInfo = ConcreteInfo.empty();

    public ConcreteEntity() {
        super(ConcreteEntityIdentifier.empty());

    }

    public ConcreteEntity(ConcreteEntityIdentifier aConcreteEntityIdentifier, ConcreteInfo aConcreteInfo) {
        super(aConcreteEntityIdentifier);
        concreteInfo = aConcreteInfo;

    }

    public static ConcreteEntity empty() {
        return new ConcreteEntity();

    }

    public static ConcreteEntity of(ConcreteEntityIdentifier aConcreteEntityIdentifier, ConcreteInfo aConcreteInfo) {

        return new ConcreteEntity(aConcreteEntityIdentifier, aConcreteInfo);
    }

    public static ConcreteEntityBuilder builder() {
        return new ConcreteEntityBuilder();

    }

    public ConcreteInfo concreteInfo() {
        return concreteInfo;

    }

}
