package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HoursTest {
    @Test
    @Tag("small")
    public void of() {
        Hours target = Hours.of(10);

        assertThat(target)
                .isNotNull();

        assertThat(target.asInteger())
                .isEqualTo(10);

    }

    @Test
    @Tag("small")
    public void empty() {
        Hours target = Hours.empty();

        assertThat(target)
                .isNotNull();

        assertThat(target.isEmpty())
                .isTrue();

    }

    @Test
    @Tag("small")
    public void zero() {
        Hours target = Hours.zero();

        assertThat(target)
                .isNotNull();

        assertThat(target.asInteger())
                .isEqualTo(0);


    }

}
