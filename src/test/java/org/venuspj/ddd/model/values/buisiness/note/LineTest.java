package org.venuspj.ddd.model.values.buisiness.note;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        Line target = Line.of("testData");
        assertThat(target)
                .isNotNull();
        assertThat(target.toString())
                .isNotNull()
                .isEqualTo("Line{value:\"testData\"}");
    }

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        Line target = Line.empty();
        assertThat(target.isEmpty())
                .isTrue();
    }

}
