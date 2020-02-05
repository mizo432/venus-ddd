package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleAddressInformationTest {

    @Test
    @Tag(TestSize.SMALL)
    public void toString1() {
        SimpleAddressInformation target = SimpleAddressInformation.empty();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs1() {
        SimpleAddressInformation target = SimpleAddressInformation.empty();
        boolean actual = target.sameValueAs(null);
        assertThat(actual)
                .isFalse();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs2() {
        SimpleAddressInformation target = SimpleAddressInformation.empty();
        boolean actual = target.sameValueAs(target);
        assertThat(actual)
                .isTrue();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs3() {
        SimpleAddressInformation arg = SimpleAddressInformation.empty();
        SimpleAddressInformation target = SimpleAddressInformation.empty();
        boolean actual = target.sameValueAs(arg);
        assertThat(actual)
                .isTrue();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void equals1() {
        AddressInformation arg = AddressInformation.empty();
        SimpleAddressInformation target = SimpleAddressInformation.empty();
        boolean actual = target.equals(arg);
        assertThat(actual)
                .isFalse();

        System.out.println(target.toString());

    }

}
