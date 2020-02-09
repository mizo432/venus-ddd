package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class TargetDateTimeTest {
    @Test
    @Tag(TestSize.SMALL)
    public void of() {

        TargetDateTime target = TargetDateTime.of(LocalDateTime.now());

        boolean actual = target.isPresent();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {

        TargetDateTime target = TargetDateTime.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void asTest() {
        LocalDateTime arg = LocalDateTime.now();

        TargetDateTime target = TargetDateTime.of(arg);

        String actual = target.asText();

//        System.out.println(actual);

        assertThat(actual)
                .isEqualTo(arg.toString());

    }

}
