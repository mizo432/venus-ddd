package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class CityCodeTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        CityCode target = CityCode.of("003");
        assertThat(target)
                .isNotNull();
        assertThat(target.isEmpty())
                .isFalse();
        assertThat(target.asText())
                .isEqualTo("003");


    }

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        CityCode target = CityCode.empty();
        assertThat(target)
                .isNotNull();
        assertThat(target.isEmpty())
                .isTrue();


    }

}
