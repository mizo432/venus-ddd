package org.venuspj.ddd.model.repository;

import org.junit.Test;
import org.venuspj.ddd.model.entity.AbstractEntityIdentifierTest.ConcreteEntityIdentifier;
import org.venuspj.ddd.model.entity.AbstractEntityTest.ConcreteEntity;
import org.venuspj.ddd.model.entity.EntityIdentifier;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class EntityNotFoundRuntimeExceptionTest {
    @Test
    public void identifier() throws Exception {
        EntityIdentifier<ConcreteEntity, ConcreteEntityIdentifier, Integer> id = ConcreteEntityIdentifier.of(1);
        EntityNotFoundRuntimeException target = new EntityNotFoundRuntimeException(id);
        assertThat(target.identifier())
                .isNotNull()
                .isEqualTo(id);

        System.out.println(toStringHelper(id).defaultConfig().toString());
        System.out.println(toStringHelper(target).defaultConfig().toString());
        System.out.println(target.getMessage());

    }

}
