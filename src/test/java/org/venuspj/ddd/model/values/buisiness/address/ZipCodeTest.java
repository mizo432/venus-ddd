package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipCodeTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        ZipCode actual = ZipCode.empty();
        assertThat(actual)
                .isNotNull();

        assertThat(actual.isEmpty())
                .isTrue();


    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        ZipCode actual = ZipCode.of("1231234");
        assertThat(actual)
                .isNotNull();

        assertThat(actual.isPresent())
                .isTrue();


    }
}
