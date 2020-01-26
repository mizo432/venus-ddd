package org.venuspj.ddd.model.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.entity.AbstractEntityIdentifierTest.ConcreteEntityIdentifier;
import org.venuspj.ddd.model.entity.AbstractEntityTest.ConcreteEntity;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class OnMemoryCrudRepositoryTest {

    OnMemoryCrudRepository<ConcreteEntity, ConcreteEntityIdentifier> onMemoryCrudRepository;

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void setUp() {
        onMemoryCrudRepository = new OnMemoryCrudRepository(ConcreteEntitiesMock.createMock(ConcreteEntitiesMock.ConcreteEntitiesMockType.EMPTY).asList());
    }

    @Test
    public void store() throws EntityNotFoundRuntimeException {
        ConcreteEntityIdentifier id = ConcreteEntityIdentifier.of(1L);
        onMemoryCrudRepository.store(new ConcreteEntity(id));
        ConcreteEntity actual = onMemoryCrudRepository.resolve(id);


        System.out.println(toStringHelper(actual).defaultConfig().toString());
        assertThat(actual)
                .isNotNull();

        assertThat(actual.getIdentifier())
                .isNotNull()
                .isEqualTo(id);

    }

    @Test
    @SuppressWarnings("unchecked")
    public void resolveAll() {
        onMemoryCrudRepository = new OnMemoryCrudRepository(ConcreteEntitiesMock.createMock(ConcreteEntitiesMock.ConcreteEntitiesMockType.ONE_ELEMENT).asList());
        ConcreteEntityIdentifier id = ConcreteEntityIdentifier.of(2L);
        onMemoryCrudRepository.store(new ConcreteEntity(id));
        List<ConcreteEntity> actual = onMemoryCrudRepository.resolveAll();

        ConcreteEntities concreteEntities = ConcreteEntities.of(actual);
        System.out.println(toStringHelper(concreteEntities).defaultConfig().toString());

        assertThat(actual)
                .isNotNull();

        assertThat(actual.size())
                .isNotNull()
                .isEqualTo(2);

    }

}