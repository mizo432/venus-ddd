package org.venuspj.ddd.model.values.buisiness;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PercentageTest {
    @Test
    @Tag("small")
    public void all() {
        Percentage target = Percentage.full();
        System.out.println(target.asText());
    }

    @Test
    @Tag("small")
    public void valueOf() {
        Percentage target = Percentage.valueOf(BigDecimal.valueOf(50));
        System.out.println(target.asText());
    }

    @Test
    @Tag("small")
    public void zero() {
        Percentage target = Percentage.zero();
        System.out.println(target.asText());
    }

    @Test
    @Tag("small")
    public void sum() {
        Percentage target = Percentage.sum(Percentage.full(), Percentage.full());
        System.out.println(target.asText());
        assertThat(target)
                .isEqualTo(Percentage.valueOf(BigDecimal.valueOf(200)));
    }

}
