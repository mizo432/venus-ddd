package org.venuspj.ddd.model.forTest.model.concrete;

import org.venuspj.ddd.model.entity.AbstractEntity;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class ConcreteEntity extends AbstractEntity<ConcreteEntity, ConcreteEntityIdentifier> {

    public ConcreteEntity() {
        super(new ConcreteEntityIdentifier());

    }

    public ConcreteEntity(ConcreteEntityIdentifier concreteEntityIdentifier) {
        super(concreteEntityIdentifier);

    }

    @Override
    public boolean sameValueAs(ConcreteEntity other) {
        if (isNull(other))
            return false;
        if (getIdentifier().isEmpty() || other.getIdentifier().isEmpty())
            return false;
        return equal(getIdentifier(), other.getIdentifier());
    }
}
