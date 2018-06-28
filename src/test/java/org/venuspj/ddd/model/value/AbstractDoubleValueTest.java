package org.venuspj.ddd.model.value;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class AbstractDoubleValueTest {

    @Test
    public void equalsText() {
        ConcreteDoubleValue target = new ConcreteDoubleValue(0.1d);
        assertThat(target.equals(new ConcreteDoubleValue(0.1d))).isTrue();
    }

    @Test
    public void hashCodeTest() {
        ConcreteDoubleValue target = new ConcreteDoubleValue(0.1d);
        assertThat(target.hashCode()).isEqualTo(new ConcreteDoubleValue(0.1d).hashCode());
    }

    static class ConcreteDoubleValue extends AbstractDoubleValue<ConcreteDoubleValue> {

        public ConcreteDoubleValue(Double value) {
            super(value);
        }
    }
}