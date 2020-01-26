package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.ConcreteEntity;
import org.venuspj.ddd.model.entity.ConcreteEntityIdentifier;

public class ConcreteEntityMock {
    public static ConcreteEntity createMock(ConcreteEntityMockType concreteEntityMockType) {
        return concreteEntityMockType.create();
    }

    public enum ConcreteEntityMockType {
        SIMPLE {
            @Override
            public ConcreteEntity create() {
                return new ConcreteEntity(ConcreteEntityIdentifier.of(1L));
            }
        };

        public abstract ConcreteEntity create();
    }

}
