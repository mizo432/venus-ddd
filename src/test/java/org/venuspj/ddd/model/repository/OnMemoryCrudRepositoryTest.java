package org.venuspj.ddd.model.repository;

import org.junit.Before;
import org.junit.Test;
import org.venuspj.ddd.model.entity.DefaultEntityIdentifier;
import org.venuspj.util.uuidProvider.UuidProvider;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class OnMemoryCrudRepositoryTest {

    OnMemoryCrudRepository<EntityNotFoundRuntimeExceptionTest.DummyEntity> onMemoryCrudRepository;

    @Before
    public void setUp(){
        onMemoryCrudRepository = new OnMemoryCrudRepository(DummyEntitiesMock.createMock(DummyEntitiesMock.MockType.EMPTY));
    }

    @Test
    public void store(){
        DefaultEntityIdentifier<EntityNotFoundRuntimeExceptionTest.DummyEntity> id = new DefaultEntityIdentifier<EntityNotFoundRuntimeExceptionTest.DummyEntity>(EntityNotFoundRuntimeExceptionTest.DummyEntity.class, UuidProvider.randomUUID());
        onMemoryCrudRepository.store(new EntityNotFoundRuntimeExceptionTest.DummyEntity(id));
        EntityNotFoundRuntimeExceptionTest.DummyEntity actual = onMemoryCrudRepository.resolve(id);
        assertThat(actual)
                .isNotNull();

        assertThat(actual.getIdentifier())
                .isNotNull()
                .isEqualTo(id);

    }

    @Test
    public void resolveAll(){
        onMemoryCrudRepository = new OnMemoryCrudRepository(DummyEntitiesMock.createMock(DummyEntitiesMock.MockType.ONE_ELEMENT));
        DefaultEntityIdentifier<EntityNotFoundRuntimeExceptionTest.DummyEntity> id = new DefaultEntityIdentifier<EntityNotFoundRuntimeExceptionTest.DummyEntity>(EntityNotFoundRuntimeExceptionTest.DummyEntity.class, UuidProvider.randomUUID());
        onMemoryCrudRepository.store(new EntityNotFoundRuntimeExceptionTest.DummyEntity(id));

        List<EntityNotFoundRuntimeExceptionTest.DummyEntity> actual = onMemoryCrudRepository.resolveAll();
        assertThat(actual)
                .isNotNull();

        assertThat(actual.size())
                .isNotNull()
                .isEqualTo(2);

    }

}