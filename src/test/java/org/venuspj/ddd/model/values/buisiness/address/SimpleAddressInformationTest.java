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
        System.out.println(arg);
        System.out.println(target);

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

    @Test
    @Tag(TestSize.SMALL)
    public void builder1() {
        SimpleAddressInformation target = SimpleAddressInformation
                .builder()
                .withPrefecture(Prefecture.empty())
                .withAddressCode(AddressCode.empty())
                .withCity(City.empty())
                .withAza(OoAza.empty())
                .withKoAza(Aza.empty())
                .withPostalCode(ZipCode.empty())
                .build();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void builder2() {
        SimpleAddressInformation target = SimpleAddressInformation
                .builder()
                .withPrefecture(null)
                .withAddressCode(null)
                .withCity(null)
                .withAza(null)
                .withKoAza(null)
                .withPostalCode(null)
                .build();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void builder3() {
        SimpleAddressInformation target = SimpleAddressInformation
                .builder()
                .apply(SimpleAddressInformation.empty());

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of1() {
        SimpleAddressInformation target = SimpleAddressInformation
                .of(ZipCode.empty(), AddressCode.empty(), Prefecture.empty(), City.empty(), OoAza.empty(), Aza.empty(), AddressBarCode.empty());

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    public static class SimpleAddressInformationMock {

        public static SimpleAddressInformation empty() {
            return SimpleAddressInformation.empty();

        }

        public static SimpleAddressInformation existsPostalCode() {
            return SimpleAddressInformation
                    .builder()
                    .withPostalCode(ZipCode.of("1234567"))
                    .build();
        }

        public static SimpleAddressInformation full() {
            return SimpleAddressInformation
                    .builder()
                    .withAddressCode(AddressCode.of("12345678901"))
                    .withPostalCode(ZipCode.of("1234567"))
                    .withPrefecture(Prefecture.of(PrefectureIdentifier.of(1L), PrefectureInformation.empty()))
                    .withAza(OoAzaTest.AzaMock.full())
                    .build();
        }
    }

}
