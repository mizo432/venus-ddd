package org.venuspj.ddd.model.values.buisiness.quantity;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.Unit;
import org.venuspj.ddd.model.values.buisiness.address.SimpleAddress;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class QuantityDecimalAndUnitTest {
    @Test
    @Tag("small")
    public void empty() {
        QuantityDecimalAndUnit target = QuantityDecimalAndUnit.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void of() {
        QuantityDecimalAndUnit target = QuantityDecimalAndUnit.of(QuantityDecimal.empty(), Unit.empty());

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void sameValueAs1() {
        QuantityDecimalAndUnit target = QuantityDecimalAndUnit.empty();

        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void sameValueAs2() {
        QuantityDecimalAndUnit target = QuantityDecimalAndUnit.empty();

        boolean actual = target.sameValueAs(null);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    public void sameValueAs3() {
        QuantityDecimalAndUnit arg = QuantityDecimalAndUnit.empty();
        QuantityDecimalAndUnit target = QuantityDecimalAndUnit.empty();

        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void toString1() {
        QuantityDecimalAndUnit target = QuantityDecimalAndUnit.empty();

        System.out.println(target.toString());

    }

    @Test
    @Tag("small")
    public void equals1() {
        SimpleAddress arg = SimpleAddress.empty();
        QuantityDecimalAndUnit target = QuantityDecimalAndUnit.empty();
        boolean actual = target.equals(arg);
        assertThat(actual)
                .isFalse();

        System.out.println(target.toString());

    }

    @Test
    @Tag("small")
    public void isEmpty1() {
        QuantityDecimalAndUnit target = QuantityDecimalAndUnit.empty();
        boolean actual = target.isEmpty();
        assertThat(actual)
                .isTrue();

        System.out.println(target.toString());

    }

    @Test
    @Tag("small")
    public void isEmpty2() {
        QuantityDecimalAndUnit target = QuantityDecimalAndUnitMock.empty();
        boolean actual = target.isEmpty();
        assertThat(actual)
                .isTrue();

        System.out.println(target.toString());

    }

    @Test
    @Tag("small")
    public void isEmpty3() {
        QuantityDecimalAndUnit target = QuantityDecimalAndUnitMock.existQuantityDecimal();
        boolean actual = target.isEmpty();
        assertThat(actual)
                .isFalse();


    }

    @Test
    @Tag("small")
    public void isEmpty4() {
        QuantityDecimalAndUnit target = QuantityDecimalAndUnitMock.existUnit();
        boolean actual = target.isEmpty();
        assertThat(actual)
                .isFalse();


    }

    @Test
    @Tag("small")
    public void isEmpty5() {
        QuantityDecimalAndUnit target = QuantityDecimalAndUnitMock.full();
        boolean actual = target.isEmpty();
        assertThat(actual)
                .isFalse();


    }

    private static class QuantityDecimalAndUnitMock {
        public static QuantityDecimalAndUnit empty() {
            return QuantityDecimalAndUnit.empty();

        }

        public static QuantityDecimalAndUnit full() {
            return QuantityDecimalAndUnit.of(BigDecimal.ZERO, "個");

        }

        public static QuantityDecimalAndUnit existUnit() {
            return QuantityDecimalAndUnit.of(QuantityDecimal.empty(), Unit.of("個"));
        }

        public static QuantityDecimalAndUnit existQuantityDecimal() {
            return QuantityDecimalAndUnit.of(QuantityDecimal.of(BigDecimal.ZERO), Unit.empty());
        }
    }
}
