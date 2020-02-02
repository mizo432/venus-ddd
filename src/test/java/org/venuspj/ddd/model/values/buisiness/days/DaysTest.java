package org.venuspj.ddd.model.values.buisiness.days;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class DaysTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        Days target = Days.of(10);

        assertThat(target)
                .isNotNull();

        assertThat(target.asInteger())
                .isEqualTo(10);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        Days target = Days.empty();

        assertThat(target)
                .isNotNull();

        assertThat(target.isEmpty())
                .isTrue();

    }
}
