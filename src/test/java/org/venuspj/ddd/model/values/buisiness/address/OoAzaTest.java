package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.name.Name;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class OoAzaTest {
    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        OoAza target = OoAza.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        OoAza target = OoAza.of(OoAzaIdentifier.of(1L), OoAzaCode.of("001"), Name.of("千代田"), Name.of("チヨダ"));

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs1() {
        OoAzaInformation target = OoAzaInformation.empty();

        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs2() {
        OoAzaInformation target = OoAzaInformation.empty();

        boolean actual = target.sameValueAs(null);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs3() {
        OoAzaInformation arg = OoAzaInformation.empty();
        OoAzaInformation target = OoAzaInformation.empty();

        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void toString1() {
        OoAzaInformation target = OoAzaInformation.empty();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void equals1() {
        SimpleAddressInformation arg = SimpleAddressInformation.empty();
        OoAzaInformation target = OoAzaInformation.empty();
        boolean actual = target.equals(arg);
        assertThat(actual)
                .isFalse();

        System.out.println(target.toString());

    }

}
