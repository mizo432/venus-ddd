package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetDateTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {

        TargetDate target = TargetDate.of(LocalDate.now());

        boolean actual = target.isPresent();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {

        TargetDate target = TargetDate.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

}
