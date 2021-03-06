package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetYearMonthTest {

    @Test
    @Tag("small")
    public void of() {

        TargetYearMonth target = TargetYearMonth.of(YearMonth.now());

        boolean actual = target.isPresent();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void empty() {

        TargetYearMonth target = TargetYearMonth.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void asTest() {
        YearMonth arg = YearMonth.now();

        TargetYearMonth target = TargetYearMonth.of(arg);

        String actual = target.asText();

//        System.out.println(actual);

        assertThat(actual)
                .isEqualTo(arg.toString());

    }

}
