package org.venuspj.ddd.model.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.entity.AbstractEntityIdentifierTest.ConcreteEntityIdentifier;
import org.venuspj.ddd.model.entity.AbstractEntityTest.ConcreteEntity;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class ConcreteServiceTest {

    OnMemoryCrudRepository<ConcreteEntity, ConcreteEntityIdentifier> onMemoryCrudRepository;

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void setUp() {
        onMemoryCrudRepository = new OnMemoryCrudRepository(ConcreteEntitiesMock.createMock(ConcreteEntitiesMock.ConcreteEntitiesMockType.EMPTY).asList());
    }

    @Test
    public void execute() throws EntityNotFoundRuntimeException {
        ConcreteService targetService = new ConcreteService(onMemoryCrudRepository);
        ConcreteServiceArg arg = new ConcreteServiceArg();
        arg.setConcreteEntityIdentifier(1L);

        ConcreteServiceResult actual = targetService.execute(arg);

        assertThat(actual)
                .isNotNull();

        assertThat(actual.getIdentifier())
                .isNotNull()
                .isEqualTo(ConcreteEntityIdentifier.of(1L));

    }

}