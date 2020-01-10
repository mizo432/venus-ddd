package org.venuspj.ddd.model.entity;

import org.junit.Test;
import org.venuspj.ddd.model.entity.AbstractEntityTest.ConcreteEntity;

import static org.venuspj.util.objects2.Objects2.*;

public class AbstractEntityIdentifierTest {

    @Test
    public void test01() {
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.of(1L);
        System.out.println(toStringHelper(target).defaultConfig().toString());
    }

    public static class ConcreteEntityIdentifier extends AbstractEntityIdentifier<ConcreteEntity, ConcreteEntityIdentifier> {
        Long value;

        public ConcreteEntityIdentifier() {
            super(ConcreteEntity.class);
        }

        @Override
        public boolean sameValueAs(ConcreteEntityIdentifier other) {
            return nonNull(other) && (equal(kind, other.kind) && equal(value, other.value));
        }

        ConcreteEntityIdentifier(Long value) {
            super(ConcreteEntity.class);
            this.value = value;
        }

        public static ConcreteEntityIdentifier of(Long value) {
            return new ConcreteEntityIdentifier(value);

        }

        @Override
        public boolean isEmpty() {
            return isNull(value);
        }

        @Override
        public Long asLong() {
            return value;
        }

        @Override
        public String asText() {
            return value.toString();
        }

        @Override
        public Long getValue() {
            return value;
        }
    }
}
