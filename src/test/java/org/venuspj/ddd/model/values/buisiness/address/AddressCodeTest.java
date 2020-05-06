package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressCodeTest {
    @Test
    @Tag("small")
    public void of() {
        AddressCode target = AddressCode.of("12345678901");
        assertThat(target.asText())
                .isEqualTo("12345678901");
    }
}
