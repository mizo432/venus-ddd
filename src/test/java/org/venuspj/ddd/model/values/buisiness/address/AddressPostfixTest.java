package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressPostfixTest {

    @Test
    public void of() {
        String aValue = "ABC";

        AddressPostfix target = AddressPostfix.of(aValue);

        String actual = target.getValue();

        assertThat(actual)
                .isEqualTo("ABC");

    }
}
