package org.venuspj.ddd.model.values.buisiness.rate;

import org.junit.Test;
import org.venuspj.ddd.model.values.buisiness.percentage.Percentage;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class RateTest {
    @Test
    public void all() {
        Rate target = Rate.all();
        System.out.println(target.asText());
    }

    @Test
    public void valueOf() {
        Rate target = Rate.valueOf(BigDecimal.valueOf(0.5));
        System.out.println(target.asText());
    }

    @Test
    public void zero() {
        Percentage target = Percentage.zero();
        System.out.println(target.asText());
    }

    @Test
    public void sum() {
        Rate target = Rate.sum(Rate.all(), Rate.all());
        System.out.println(target.asText());
        assertThat(target)
                .isEqualTo(Rate.valueOf(BigDecimal.valueOf(2)));
    }

    @Test
    public void toPercentage() {
        Rate target = Rate.all();

        assertThat(target.toPercentage())
                .isEqualTo(Percentage.all());
    }

}
