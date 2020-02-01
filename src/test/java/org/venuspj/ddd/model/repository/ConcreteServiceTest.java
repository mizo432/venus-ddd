package org.venuspj.ddd.model.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.forTest.application.service.concrete.ConcreteService;
import org.venuspj.ddd.model.forTest.application.service.concrete.arg.ConcreteServiceArg;
import org.venuspj.ddd.model.forTest.application.service.concrete.result.ConcreteServiceResult;
import org.venuspj.ddd.model.forTest.infrastructure.db.ConcreteEntityDataSource;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntitiesMock;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityIdentifier;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityRepository;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;


public class ConcreteServiceTest {

    private ConcreteEntityRepository concreteEntityRepository;

    @BeforeEach
    @SuppressWarnings("unchecked")
    public void setUp() {
        concreteEntityRepository = new ConcreteEntityDataSource(ConcreteEntitiesMock.createMock(ConcreteEntitiesMock.ConcreteEntitiesMockType.EMPTY).asList());
    }

    @Tag(TestSize.SMALL)
    @Test
    public void execute() throws EntityNotFoundRuntimeException {
        ConcreteService targetService = new ConcreteService(concreteEntityRepository);
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