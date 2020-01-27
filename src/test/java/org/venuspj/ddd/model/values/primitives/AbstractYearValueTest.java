package org.venuspj.ddd.model.values.primitives;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.test.consts.TestSize;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractYearValueTest {

    @Test
    @Tag(TestSize.SMALL)
    public void constructor() {
        ConcreteYearValue target = ConcreteYearValue.of(Year.of(2020));
        String actual = target.toString();
        assertThat(actual)
                .isEqualTo("ConcreteYearValue{value:2020}");

    }

    @Test
    @Tag(TestSize.SMALL)
    public void asYear() {
        ConcreteYearValue target = ConcreteYearValue.of(Year.of(2020));
        Year actual = target.asYear();
        assertThat(actual)
                .isEqualTo(Year.of(2020));

    }


    private static class ConcreteYearValue extends AbstractYearValue<ConcreteYearValue> {

        public ConcreteYearValue(Year aValue) {
            super(aValue);
        }

        public static ConcreteYearValue of(Year aValue) {
            return new ConcreteYearValue(aValue);
        }
    }
}
