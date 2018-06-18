package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.entity.AbstractEntityTest.ConcreteEntity;
import org.venuspj.ddd.model.entity.AbstractLongIdentifierValueTest.ConcreteLongIdentifierValue;

public class AbstractEntityIdentifierTest {

    public static class ConcreteEntityIdentifier extends AbstractEntityIdentifier<ConcreteEntity, ConcreteEntityIdentifier, ConcreteLongIdentifierValue> {

        public ConcreteEntityIdentifier() {
            super(ConcreteEntity.class);
        }

        ConcreteEntityIdentifier(ConcreteLongIdentifierValue value) {
            super(ConcreteEntity.class, value);
        }

        public static ConcreteEntityIdentifier of(ConcreteLongIdentifierValue value) {
            return new ConcreteEntityIdentifier(value);
        }

    }
}
