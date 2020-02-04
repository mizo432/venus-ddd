package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.entity.AbstractEntity;

import static org.venuspj.util.objects2.Objects2.isNull;
import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class ConcreteEntity extends AbstractEntity<ConcreteEntity, ConcreteEntityIdentifier> {

    public ConcreteEntity() {
        super(new ConcreteEntityIdentifier());

    }

    public ConcreteEntity(ConcreteEntityIdentifier concreteEntityIdentifier) {
        super(concreteEntityIdentifier);

    }

    public static ConcreteEntity empty() {
        return new ConcreteEntity();
    }

    public static ConcreteEntity of(ConcreteEntityIdentifier aConcreteEntityIdentifier) {
        return new ConcreteEntity(aConcreteEntityIdentifier);
    }

    @Override
    public boolean sameValueAs(ConcreteEntity other) {
        if (isNull(other))
            return false;
        if (getIdentifier().isEmpty() || other.getIdentifier().isEmpty())
            return false;
        return sameIdentifierAs(other);
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();

    }
}
