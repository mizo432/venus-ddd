package org.venuspj.ddd.model.values;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.primitives.AbstractDoubleValue;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;


public class AbstractDoubleValueTest {

    @Test
    @Tag(TestSize.SMALL)
    public void equalsText() {
        ConcreteDoubleValue target = new ConcreteDoubleValue(0.1d);
        assertThat(target.equals(new ConcreteDoubleValue(0.1d)))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void hashCodeTest() {
        ConcreteDoubleValue target = new ConcreteDoubleValue(0.1d);
        assertThat(target.hashCode())
                .isEqualTo(new ConcreteDoubleValue(0.1d).hashCode());
    }

    /**
     *
     */
    static class ConcreteDoubleValue extends AbstractDoubleValue<ConcreteDoubleValue> {

        public ConcreteDoubleValue(Double value) {
            super(value);
        }
    }
}