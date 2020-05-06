package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetYearTest {
    @Test
    @Tag("small")
    public void of() {

        TargetYear target = TargetYear.of(Year.now());

        boolean actual = target.isPresent();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void toString1() {
        Year arg = Year.now();

        TargetYear target = TargetYear.of(arg);

        String actual = target.toString();

        System.out.println(actual);

    }

    @Test
    @Tag("small")
    public void asTest() {
        Year arg = Year.now();

        TargetYear target = TargetYear.of(arg);

        String actual = target.asText();

//        System.out.println(actual);

        assertThat(actual)
                .isEqualTo(arg.toString());

    }

    @Test
    @Tag("small")
    public void empty() {

        TargetYear target = TargetYear.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

}
