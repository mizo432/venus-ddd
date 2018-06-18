package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.entity.AbstractEntityIdentifierTest.ConcreteEntityIdentifier;

public class AbstractEntityTest {

    public static class ConcreteEntity extends AbstractEntity<ConcreteEntity, ConcreteEntityIdentifier> {

        public ConcreteEntity() {

            super(new ConcreteEntityIdentifier());
        }

        public ConcreteEntity(ConcreteEntityIdentifier concreteEntityIdentifier) {
            super(concreteEntityIdentifier);
        }

    }
}
