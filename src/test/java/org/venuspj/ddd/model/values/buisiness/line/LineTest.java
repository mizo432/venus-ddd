package org.venuspj.ddd.model.values.buisiness.line;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {

    @Test
    public void of() {
        Line target = Line.of("testData");
        assertThat(target)
                .isNotNull();
        assertThat(target.toString())
                .isNotNull()
                .isEqualTo("Line{value:\"testData\"}");
    }
}
