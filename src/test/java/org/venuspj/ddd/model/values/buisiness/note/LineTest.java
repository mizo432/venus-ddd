package org.venuspj.ddd.model.values.buisiness.note;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @Tag("small")
    public void of() {
        Line target = Line.of("testData");
        assertThat(target)
                .isNotNull();
        assertThat(target.toString())
                .isNotNull()
                .isEqualTo("Line{value:\"testData\"}");
    }

    @Test
    @Tag("small")
    public void empty() {
        Line target = Line.empty();
        assertThat(target.isEmpty())
                .isTrue();
    }

}
