package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        Address target = Address.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        Address target = Address.of(AddressIdentifier.empty(), SimpleAddressInformation.empty());

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void getAddressInformation() {
        Address target = Address.of(AddressIdentifier.empty(), SimpleAddressInformation.empty());

        SimpleAddressInformation actual = target.getAddressInformation();

        assertThat(actual)
                .isNotNull();

    }

}
