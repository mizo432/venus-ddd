package org.venuspj.ddd.model.values.buisiness.amount;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.money.TaxPercentage;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class TaxPercentageTest {

    @Test
    @Tag("small")
    public void zero() {
        TaxPercentage target = TaxPercentage.zero();

        assertThat(target)
                .isNotNull();

        assertThat(target.getValue())
                .isEqualTo(BigDecimal.ZERO);

    }

    @Test
    @Tag("small")
    public void full() {
        TaxPercentage target = TaxPercentage.all();

        assertThat(target)
                .isNotNull();

        assertThat(target.getValue())
                .isEqualTo(BigDecimal.valueOf(100));

    }

    @Test
    @Tag("small")
    public void valueOf() {
        TaxPercentage target = TaxPercentage.valueOf(BigDecimal.valueOf(0.1));

        assertThat(target)
                .isNotNull();

        assertThat(target.getValue())
                .isEqualTo(BigDecimal.valueOf(0.1));

    }

    @Test
    @Tag("small")
    public void sum() {
        TaxPercentage currentTaxPercentage = TaxPercentage.valueOf(BigDecimal.valueOf(10));

        TaxPercentage actual = TaxPercentage.sum(TaxPercentage.all(), currentTaxPercentage);

        assertThat(actual)
                .isNotNull();

        assertThat(actual.getValue())
                .isEqualTo(BigDecimal.valueOf(110));

    }

}
