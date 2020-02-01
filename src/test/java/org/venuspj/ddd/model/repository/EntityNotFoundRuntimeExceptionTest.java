package org.venuspj.ddd.model.repository;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.entity.EntityIdentifier;
import org.venuspj.ddd.model.forTest.model.concrete.ConcreteEntity;
import org.venuspj.ddd.model.forTest.model.concrete.ConcreteEntityIdentifier;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class EntityNotFoundRuntimeExceptionTest {
    @Test
    @Tag(TestSize.SMALL)
    public void identifier() {
        EntityIdentifier<ConcreteEntity, ConcreteEntityIdentifier> id = ConcreteEntityIdentifier.of(1L);
        EntityNotFoundRuntimeException target = new EntityNotFoundRuntimeException(id);
        assertThat(target.identifier())
                .isNotNull()
                .isEqualTo(id);

        System.out.println(toStringHelper(id).defaultConfig().toString());
        System.out.println(toStringHelper(target).defaultConfig().toString());
        System.out.println(target.getMessage());

    }

}
