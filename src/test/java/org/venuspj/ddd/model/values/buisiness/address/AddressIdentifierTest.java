package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressIdentifierTest {

    @Test
    @Tag("small")
    public void empty() {
        AddressIdentifier target = AddressIdentifier.empty();
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();
    }

    @Test
    @Tag("small")
    public void of() {
        AddressIdentifier target = AddressIdentifier.of(1L);
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isFalse();
    }

    @Test
    @Tag("small")
    public void sameValueIf() {
        AddressIdentifier target = AddressIdentifier.of(1L);
        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();
    }
}
