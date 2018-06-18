package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.AbstractEntityIdentifierTest.ConcreteEntityIdentifier;
import org.venuspj.ddd.model.entity.AbstractEntityTest.ConcreteEntity;
import org.venuspj.ddd.model.entity.AbstractLongIdentifierValueTest.ConcreteLongIdentifierValue;

public class ConcreteEntityMock {
    public static ConcreteEntity createMock(ConcreteEntityMockType concreteEntityMockType) {
        return concreteEntityMockType.create();
    }

    public enum ConcreteEntityMockType {
        SIMPLE {
            @Override
            public ConcreteEntity create() {
                return new ConcreteEntity(ConcreteEntityIdentifier.of(ConcreteLongIdentifierValue.of(1L)));
            }
        };

        public abstract ConcreteEntity create();
    }

}
