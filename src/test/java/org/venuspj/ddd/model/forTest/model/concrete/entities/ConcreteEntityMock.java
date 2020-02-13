package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.values.buisiness.name.Name;

public class ConcreteEntityMock {
    public static ConcreteEntity createMock(ConcreteEntityMockType concreteEntityMockType) {
        return concreteEntityMockType.create();
    }

    public enum ConcreteEntityMockType {
        SIMPLE {
            @Override
            public ConcreteEntity create() {
                return new ConcreteEntity(ConcreteEntityIdentifier.of(1L), ConcreteInfo.of(Name.of("1L")));
            }
        };

        public abstract ConcreteEntity create();
    }

}
