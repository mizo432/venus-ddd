package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ZipCodeTest {

    @Test
    @Tag("small")
    public void empty() {
        ZipCode actual = ZipCode.empty();
        assertThat(actual)
                .isNotNull();

        assertThat(actual.isEmpty())
                .isTrue();


    }

    @Test
    @Tag("small")
    public void of() {
        ZipCode actual = ZipCode.of("1231234");
        assertThat(actual)
                .isNotNull();

        assertThat(actual.isPresent())
                .isTrue();


    }
}
