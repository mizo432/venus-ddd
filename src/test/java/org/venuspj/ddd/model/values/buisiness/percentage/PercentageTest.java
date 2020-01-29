package org.venuspj.ddd.model.values.buisiness.percentage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.test.consts.TestSize;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class PercentageTest {
    @Test
    @Tag(TestSize.SMALL)
    public void all() {
        Percentage target = Percentage.all();
        System.out.println(target.asText());
    }

    @Test
    @Tag(TestSize.SMALL)
    public void valueOf() {
        Percentage target = Percentage.valueOf(BigDecimal.valueOf(50));
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
        Percentage target = Percentage.sum(Percentage.all(), Percentage.all());
        System.out.println(target.asText());
        assertThat(target)
                .isEqualTo(Percentage.valueOf(BigDecimal.valueOf(200)));
    }

}
