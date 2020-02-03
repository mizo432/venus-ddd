package org.venuspj.ddd.model.values.buisiness.amount;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.percentage.Percentage;
import org.venuspj.tests.constants.TestSize;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxRateTest {

    @Test
    @Tag(TestSize.SMALL)
    public void zero() {
        TaxRate target = TaxRate.zero();

        assertThat(target)
                .isNotNull();

        assertThat(target.getValue())
                .isEqualTo(BigDecimal.ZERO);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void full() {
        TaxRate target = TaxRate.all();

        assertThat(target)
                .isNotNull();

        assertThat(target.getValue())
                .isEqualTo(BigDecimal.valueOf(1));

    }

    @Test
    @Tag(TestSize.SMALL)
    public void valueOf() {
        TaxRate target = TaxRate.valueOf(BigDecimal.valueOf(0.1));

        assertThat(target)
                .isNotNull();

        assertThat(target.getValue())
                .isEqualTo(BigDecimal.valueOf(0.1));

    }

    @Test
    @Tag(TestSize.SMALL)
    public void toPercentage() {
        TaxRate target = TaxRate.valueOf(BigDecimal.valueOf(0.1));

        Percentage actual = target.toPercentage();

        assertThat(actual)
                .isNotNull();

        assertThat(actual.getValue())
                .isEqualTo(BigDecimal.valueOf(10.0));

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sum() {
        TaxRate currentTaxRate = TaxRate.valueOf(BigDecimal.valueOf(0.1));

        TaxRate actual = TaxRate.sum(TaxRate.all(), currentTaxRate);

        assertThat(actual)
                .isNotNull();

        assertThat(actual.getValue())
                .isEqualTo(BigDecimal.valueOf(1.1));

    }

}
