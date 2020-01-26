package org.venuspj.ddd.model.forTest.model.concrete;

import org.venuspj.util.collect.Lists2;

import static org.venuspj.util.collect.Lists2.newArrayList;

public enum ConcreteEntitiesMock {
    ;

    public static ConcreteEntities createMock(ConcreteEntitiesMockType concreteEntitiesMockType) {
        return concreteEntitiesMockType.create();
    }

    public enum ConcreteEntitiesMockType {
        EMPTY {
            @Override
            public ConcreteEntities create() {
                return ConcreteEntities.of(newArrayList());
            }
        }, ONE_ELEMENT {
            @Override
            public ConcreteEntities create() {
                return ConcreteEntities.of(Lists2.newArrayList(
                        ConcreteEntityMock.createMock(ConcreteEntityMock.ConcreteEntityMockType.SIMPLE)));
            }
        };

        public abstract ConcreteEntities create();
    }
}
