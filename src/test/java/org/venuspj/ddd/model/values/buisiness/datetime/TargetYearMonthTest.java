package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetYearMonthTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {

        TargetYearMonth target = TargetYearMonth.of(YearMonth.now());

        boolean actual = target.isPresent();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {

        TargetYearMonth target = TargetYearMonth.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }
}
