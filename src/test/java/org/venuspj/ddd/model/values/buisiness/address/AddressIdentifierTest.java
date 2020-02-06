package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressIdentifierTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        AddressIdentifier target = AddressIdentifier.empty();
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        AddressIdentifier target = AddressIdentifier.of(1L);
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isFalse();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueIf() {
        AddressIdentifier target = AddressIdentifier.of(1L);
        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();
    }
}
