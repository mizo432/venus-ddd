package org.venuspj.ddd.model.values.buisiness.name;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    public void of() {
        Name target = Name.of("testData");
        assertThat(target)
                .isNotNull();
        assertThat(target.toString())
                .isNotNull()
                .isEqualTo("Name{value:\"testData\"}");
    }
}
