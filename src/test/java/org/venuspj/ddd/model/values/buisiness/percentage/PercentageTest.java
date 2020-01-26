package org.venuspj.ddd.model.values.buisiness.percentage;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PercentageTest {
    @Test
    public void all() {
        Percentage target = Percentage.all();
        System.out.println(target.asText());
    }

    @Test
    public void valueOf() {
        Percentage target = Percentage.valueOf(BigDecimal.valueOf(50));
        System.out.println(target.asText());
    }

    @Test
    public void zero() {
        Percentage target = Percentage.zero();
        System.out.println(target.asText());
    }

    @Test
    public void sum() {
        Percentage target = Percentage.sum(Percentage.all(), Percentage.all());
        System.out.println(target.asText());
        assertThat(target)
                .isEqualTo(Percentage.valueOf(BigDecimal.valueOf(200)));
    }

}
