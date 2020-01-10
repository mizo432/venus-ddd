package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.entity.AbstractEntityIdentifierTest.ConcreteEntityIdentifier;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.isNull;

public class AbstractEntityTest {

    public static class ConcreteEntity extends AbstractEntity<ConcreteEntity, ConcreteEntityIdentifier> {

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
            return Objects2.equal(getIdentifier(), other.getIdentifier());
        }
    }
}
