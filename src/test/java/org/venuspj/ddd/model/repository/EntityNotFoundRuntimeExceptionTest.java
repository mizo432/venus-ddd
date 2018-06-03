package org.venuspj.ddd.model.repository;

import org.junit.Test;
import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.entity.DefaultEntityIdentifier;
import org.venuspj.ddd.model.entity.EntityIdentifier;

import java.util.UUID;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class EntityNotFoundRuntimeExceptionTest {
    @Test
    public void identifier() throws Exception {
        DefaultEntityIdentifier<DummyEntity> id = new DefaultEntityIdentifier<DummyEntity>(DummyEntity.class, UUID.randomUUID());
        EntityNotFoundRuntimeException target = new EntityNotFoundRuntimeException(id);
        assertThat(target.identifier())
                .isNotNull()
                .isEqualTo(id);

    }

    static class DummyEntity extends AbstractEntity<DummyEntity> {
        DummyEntity(EntityIdentifier<DummyEntity> identifier){
            super(identifier);
        }
        @Override
        public EntityIdentifier<DummyEntity> getIdentifier() {
            return super.getIdentifier();
        }

        @Override
        public DummyEntity clone() {
            return new DummyEntity(getIdentifier());

        }

    }
}
