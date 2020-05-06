package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressBarCodeTest {

    @Test
    @Tag("small")
    public void of() {
        AddressBarCode target = AddressBarCode.of("12345678901");
        assertThat(target.asText())
                .isEqualTo("12345678901");
    }

    @Test
    @Tag("small")
    public void empty() {
        AddressBarCode target = AddressBarCode.empty();
        assertThat(target.isEmpty())
                .isTrue();
    }

    @Test
    @Tag("small")
    public void equals1() {
        AddressBarCode target = AddressBarCode.of("12345678901");

        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();
    }

    @Test
    @Tag("small")
    public void equals2() {
        AddressBarCode arg = AddressBarCode.of("12345678901");
        AddressBarCode target = AddressBarCode.of("12345678901");

        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();
    }

    @Test
    @Tag("small")
    public void equals3() {
        AddressBarCode arg = AddressBarCode.empty();
        AddressBarCode target = AddressBarCode.of("12345678901");

        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isFalse();
    }

}
