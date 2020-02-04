package org.venuspj.ddd.model.values.buisiness.note;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class DescriptionTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        Description target = Description.empty();
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        Description target = Description.of(newArrayList(Line.of("DUMMY")));
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isFalse();

    }

}
