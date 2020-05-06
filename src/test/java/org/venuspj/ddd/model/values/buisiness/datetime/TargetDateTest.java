package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetDateTest {

    @Test
    @Tag("small")
    public void of() {

        TargetDate target = TargetDate.of(LocalDate.now());

        boolean actual = target.isPresent();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void empty() {

        TargetDate target = TargetDate.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void asTest() {
        LocalDate arg = LocalDate.now();

        TargetDate target = TargetDate.of(arg);

        String actual = target.asText();

//        System.out.println(actual);

        assertThat(actual)
                .isEqualTo(arg.toString());

    }

}
