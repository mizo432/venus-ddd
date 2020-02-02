package org.venuspj.ddd.model.values.buisiness.name;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class NameTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        Name target = Name.of("testData");
        assertThat(target)
                .isNotNull();
        assertThat(target.toString())
                .isNotNull()
                .isEqualTo("Name{value:\"testData\"}");
    }

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        Name target = Name.empty();
        assertThat(target)
                .isNotNull();
        assertThat(target.isEmpty())
                .isTrue();
    }
}
