package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

import static org.venuspj.util.objects2.Objects2.*;

public class ConcreteEntityIdentifier extends AbstractEntityLongIdentifier<ConcreteEntity, ConcreteEntityIdentifier> {

    public ConcreteEntityIdentifier() {
        super(ConcreteEntity.class);
    }

    public static ConcreteEntityIdentifier empty() {
        return new ConcreteEntityIdentifier();
    }

    @Override
    public boolean sameValueAs(ConcreteEntityIdentifier other) {
        return nonNull(other)
                && (equal(kind, other.kind)
                && equal(value, other.value));
    }

    ConcreteEntityIdentifier(Long aValue) {
        super(ConcreteEntity.class, aValue);
    }

    public static ConcreteEntityIdentifier of(Long value) {
        return new ConcreteEntityIdentifier(value);

    }

    @Override
    public boolean isEmpty() {
        return isNull(value);
    }

    @Override
    public Long asLong() {
        return value;
    }

    @Override
    public String asText() {
        return value.toString();
    }

    @Override
    public Long getValue() {
        return value;
    }
}
