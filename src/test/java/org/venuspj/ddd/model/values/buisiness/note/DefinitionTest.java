package org.venuspj.ddd.model.values.buisiness.note;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class DefinitionTest {

    @Test
    @Tag("small")
    public void empty() {
        Definition target = Definition.empty();

        assertThat(target)
                .isNotNull();

        assertThat(target.isEmpty())
                .isTrue();

    }

    @Test
    @Tag("small")
    public void of1() {
        Definition target = Definition.of(HeadLine.empty(), Description.empty());

        assertThat(target)
                .isNotNull();

        assertThat(target.isEmpty())
                .isTrue();

    }

    @Test
    @Tag("small")
    public void of2() {
        Definition target = Definition.of(HeadLine.of("DUMMY"), Description.empty());

        assertThat(target)
                .isNotNull();

        assertThat(target.isEmpty())
                .isFalse();

    }

    @Test
    @Tag("small")
    public void of3() {
        ArrayList<Line> description = newArrayList();
        description.add(Line.of("DUMMY1"));
        description.add(Line.of("DUMMY2"));

        Definition target = Definition.of(HeadLine.empty(), Description.of(description));

        assertThat(target)
                .isNotNull();

        assertThat(target.isEmpty())
                .isFalse();

    }

    @Test
    @Tag("small")
    public void of4() {
        ArrayList<Line> description = newArrayList();
        description.add(Line.of("DUMMY1"));
        description.add(Line.of("DUMMY2"));

        Definition target = Definition.of(HeadLine.of("DUMMY"), Description.of(description));

        assertThat(target)
                .isNotNull();

        assertThat(target.isEmpty())
                .isFalse();

    }
}
