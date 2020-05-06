package org.venuspj.ddd.model.repository;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityIdentifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class EntityNotFoundRuntimeExceptionTest {
    @Test
    @Tag("small")
    public void identifier() {
        ConcreteEntityIdentifier id = ConcreteEntityIdentifier.of(1L);
        EntityNotFoundRuntimeException target = new EntityNotFoundRuntimeException(id);
        assertThat(target.identifier())
                .isNotNull()
                .isEqualTo(id);

        System.out.println(toStringHelper(id).defaultConfig().toString());
        System.out.println(toStringHelper(target).defaultConfig().toString());
        System.out.println(target.getMessage());

    }

}
