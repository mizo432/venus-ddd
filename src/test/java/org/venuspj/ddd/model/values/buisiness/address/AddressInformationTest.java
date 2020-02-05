package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressInformationTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        AddressInformation target = AddressInformation.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        AddressInformation target = AddressInformation.of(PostalCode.empty(), AddressCode.empty(), Prefecture.EMPTY, City.empty(), Aza.empty(), KoAza.empty(), AddressPostfix.empty());

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void builder1() {
        AddressInformation target = AddressInformation
                .builder()
                .withSimpleAddressInformation(SimpleAddressInformation.empty())
                .withAddressPostfix(AddressPostfix.empty())
                .build();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void builder2() {
        AddressInformation target = AddressInformation
                .builder()
                .withSimpleAddressInformation(null)
                .withAddressPostfix(null)
                .build();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

}
