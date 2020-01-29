package org.venuspj.ddd.model.values.buisiness.rate;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.percentage.Percentage;
import org.venuspj.test.consts.TestSize;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class RateTest {
    @Test
    @Tag(TestSize.SMALL)
    public void all() {
        Rate target = Rate.all();
        System.out.println(target.asText());
    }

    @Test
    @Tag(TestSize.SMALL)
    public void valueOf() {
        Rate target = Rate.valueOf(BigDecimal.valueOf(0.5));
        System.out.println(target.asText());
    }

    @Test
    @Tag(TestSize.SMALL)
    public void zero() {
        Percentage target = Percentage.zero();
        System.out.println(target.asText());
    }

    @Test
    @Tag(TestSize.SMALL)
    public void sum() {
        Rate target = Rate.sum(Rate.all(), Rate.all());
        System.out.println(target.asText());
        assertThat(target)
                .isEqualTo(Rate.valueOf(BigDecimal.valueOf(2)));
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toPercentage() {
        Rate target = Rate.all();

        assertThat(target.toPercentage())
                .isEqualTo(Percentage.all());
    }

}
