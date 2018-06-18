package org.venuspj.ddd.model.entity;

import org.junit.Test;
import org.venuspj.util.objects2.Objects2;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class AbstractLongIdentifierValueTest {


    @Test
    public void of() {
        ConcreteLongIdentifierValue target = ConcreteLongIdentifierValue.of(10L);

        assertThat(target).isNotNull();

        assertThat(target.value).isNotNull().isEqualTo(10L);

    }


    public static class ConcreteLongIdentifierValue extends AbstractLongIdentifierValue<ConcreteLongIdentifierValue> {
        public ConcreteLongIdentifierValue() {

        }

        ConcreteLongIdentifierValue(Long value) {
            super(value);
        }

        @Override
        public boolean sameValueAs(ConcreteLongIdentifierValue other) {
            return Objects2.equal(value, other.asLong());
        }

        public static ConcreteLongIdentifierValue of(Long value) {
            return new ConcreteLongIdentifierValue(value);
        }

    }
}
