package org.venuspj.ddd.model.values.buisiness.note;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class DescriptionTest {

    @Test
    @Tag("small")
    public void empty() {
        Description target = Description.empty();
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();
    }

    @Test
    @Tag("small")
    public void of() {
        Description target = Description.of(newArrayList(Line.of("DUMMY")));
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isFalse();

    }

}
