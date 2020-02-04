package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public class ConcreteEntityIdentifier extends AbstractEntityLongIdentifier<ConcreteEntity, ConcreteEntityIdentifier> {

    public ConcreteEntityIdentifier() {
        super(ConcreteEntity.class);
    }

    public static ConcreteEntityIdentifier empty() {
        return new ConcreteEntityIdentifier();
    }

    @Override
    public boolean sameValueAs(ConcreteEntityIdentifier other) {
        return equals(other);

    }

    ConcreteEntityIdentifier(Long aValue) {
        super(ConcreteEntity.class, aValue);
    }

    public static ConcreteEntityIdentifier of(Long value) {
        return new ConcreteEntityIdentifier(value);

    }

}
