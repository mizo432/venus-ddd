package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.DefaultEntityIdentifier;
import org.venuspj.util.uuidProvider.UuidProvider;

import java.util.List;
import java.util.stream.Collectors;

import static org.venuspj.util.collect.Lists2.newArrayList;

public class DummyEntitiesMock {


    public static List<EntityNotFoundRuntimeExceptionTest.DummyEntity> createMock(MockType mockType) {
        return mockType
                .childMockTypes()
                .stream().map(childMockType-> DummyEntityMock.createMock(childMockType))
                .collect(Collectors.toList());
    }

    public enum MockType {
        EMPTY{
            @Override
            public List<DummyEntityMock.MockType> childMockTypes(){
                return newArrayList();
            }
        }
,
        ONE_ELEMENT{
            @Override
            public List<DummyEntityMock.MockType> childMockTypes(){
                return newArrayList(DummyEntityMock.MockType.FIRST);
            }

        };

        public abstract List<DummyEntityMock.MockType> childMockTypes();
    }

    private static class DummyEntityMock {
        public static EntityNotFoundRuntimeExceptionTest.DummyEntity createMock(DummyEntityMock.MockType mockType) {
            return mockType.create();

        }

        private enum  MockType {
            FIRST{
                public EntityNotFoundRuntimeExceptionTest.DummyEntity create(){
                    return new EntityNotFoundRuntimeExceptionTest.DummyEntity(new DefaultEntityIdentifier<EntityNotFoundRuntimeExceptionTest.DummyEntity>(EntityNotFoundRuntimeExceptionTest.DummyEntity.class,UuidProvider.randomUUID()));
                }

            };

            public abstract EntityNotFoundRuntimeExceptionTest.DummyEntity create();
        }
    }
}
