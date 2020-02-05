package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressPostfixTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        String aValue = "ABC";

        AddressPostfix target = AddressPostfix.of(aValue);

        String actual = target.getValue();

        assertThat(actual)
                .isEqualTo("ABC");

    }

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        String aValue = "ABC";

        AddressPostfix target = AddressPostfix.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }
}
