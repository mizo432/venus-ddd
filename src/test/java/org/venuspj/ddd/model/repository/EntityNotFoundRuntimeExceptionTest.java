package org.venuspj.ddd.model.repository;

import org.junit.Test;
import org.venuspj.ddd.model.entity.AbstractEntityIdentifierTest.ConcreteEntityIdentifier;
import org.venuspj.ddd.model.entity.AbstractEntityTest.ConcreteEntity;
import org.venuspj.ddd.model.entity.AbstractLongIdentifierValueTest.ConcreteLongIdentifierValue;
import org.venuspj.ddd.model.entity.EntityIdentifier;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class EntityNotFoundRuntimeExceptionTest {
    @Test
    public void identifier() throws Exception {
        EntityIdentifier<ConcreteEntity, ConcreteEntityIdentifier> id = ConcreteEntityIdentifier.of(ConcreteLongIdentifierValue.of(1L));
        EntityNotFoundRuntimeException target = new EntityNotFoundRuntimeException(id);
        assertThat(target.identifier())
                .isNotNull()
                .isEqualTo(id);

    }

}
