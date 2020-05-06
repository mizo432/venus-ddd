package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DaysTest {

    @Test
    @Tag("small")
    public void of() {
        Days target = Days.of(10);

        assertThat(target)
                .isNotNull();

        assertThat(target.asInteger())
                .isEqualTo(10);

    }

    @Test
    @Tag("small")
    public void empty() {
        Days target = Days.empty();

        assertThat(target)
                .isNotNull();

        assertThat(target.isEmpty())
                .isTrue();

    }
}
