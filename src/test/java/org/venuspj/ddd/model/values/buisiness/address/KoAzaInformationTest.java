package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.Name;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class KoAzaInformationTest {
    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        KoAzaInformation target = KoAzaInformation.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        KoAzaInformation target = KoAzaInformation.of(Name.empty());

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs1() {
        KoAzaInformation target = KoAzaInformation.empty();

        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs2() {
        KoAzaInformation target = KoAzaInformation.empty();

        boolean actual = target.sameValueAs(null);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs3() {
        KoAzaInformation arg = KoAzaInformation.empty();
        KoAzaInformation target = KoAzaInformation.empty();

        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void toString1() {
        KoAzaInformation target = KoAzaInformation.empty();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void equals1() {
        SimpleAddressInformation arg = SimpleAddressInformation.empty();
        KoAzaInformation target = KoAzaInformation.empty();
        boolean actual = target.equals(arg);
        assertThat(actual)
                .isFalse();


    }

    @Test
    @Tag(TestSize.SMALL)
    public void equals2() {
        SimpleAddressInformation arg = SimpleAddressInformation.empty();
        KoAzaInformation target = KoAzaInformation.empty();
        boolean actual = target.equals(null);
        assertThat(actual)
                .isFalse();


    }

}
