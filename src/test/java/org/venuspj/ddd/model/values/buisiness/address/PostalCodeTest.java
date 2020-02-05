package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class PostalCodeTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        PostalCode actual = PostalCode.empty();
        assertThat(actual)
                .isNotNull();

        assertThat(actual.isEmpty())
                .isTrue();


    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        PostalCode actual = PostalCode.of("1231234");
        assertThat(actual)
                .isNotNull();

        assertThat(actual.isPresent())
                .isTrue();


    }
}
