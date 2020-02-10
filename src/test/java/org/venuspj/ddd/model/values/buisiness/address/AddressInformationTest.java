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
        AddressInformation target = AddressInformation.of(ZipCode.empty(), AddressCode.empty(), Prefecture.EMPTY, City.empty(), OoAza.empty(), Aza.empty(), AddressPostfix.empty());

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

    @Test
    @Tag(TestSize.SMALL)
    public void builder3() {
        AddressInformation target = AddressInformation
                .builder()
                .apply(AddressInformation.empty());

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs1() {
        AddressInformation target = AddressInformation.empty();

        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs2() {
        AddressInformation target = AddressInformation.empty();

        boolean actual = target.sameValueAs(null);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs3() {
        AddressInformation arg = AddressInformation.empty();
        AddressInformation target = AddressInformation.empty();

        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void toString1() {
        AddressInformation target = AddressInformation.empty();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void equals1() {
        SimpleAddressInformation arg = SimpleAddressInformation.empty();
        AddressInformation target = AddressInformation.empty();
        boolean actual = target.equals(arg);
//        System.out.println(target.toString());

        assertThat(actual)
                .isFalse();


    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty1() {
        AddressInformation target = AddressInformationMock.empty();
        boolean actual = target.isEmpty();
//        System.out.println(target.toString());
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty2() {
        AddressInformation target = AddressInformationMock.full();
        boolean actual = target.isEmpty();
//        System.out.println(target.toString());
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty3() {
        AddressInformation target = AddressInformationMock.existsAddressPostfix();
        boolean actual = target.isEmpty();
//        System.out.println(target.toString());
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty4() {
        AddressInformation target = AddressInformationMock.existsSimpleAddressInformation();
        boolean actual = target.isEmpty();
//        System.out.println(target.toString());
        assertThat(actual)
                .isFalse();

    }

    public static class AddressInformationMock {

        public static AddressInformation one() {
            return AddressInformation
                    .builder()
                    .withSimpleAddressInformation(SimpleAddressInformationTest.SimpleAddressInformationMock.empty())
                    .withAddressPostfix(AddressPostfix.of("1-2-3"))
                    .build();
        }

        public static AddressInformation empty() {
            return AddressInformation.empty();

        }

        public static AddressInformation full() {
            return AddressInformation
                    .builder()
                    .withSimpleAddressInformation(SimpleAddressInformationTest.SimpleAddressInformationMock.existsPostalCode())
                    .withAddressPostfix(AddressPostfix.of("1-2-3"))
                    .build();
        }

        public static AddressInformation existsSimpleAddressInformation() {
            return AddressInformation
                    .builder()
                    .withSimpleAddressInformation(SimpleAddressInformationTest.SimpleAddressInformationMock.existsPostalCode())
                    .withAddressPostfix(AddressPostfix.empty())
                    .build();
        }

        public static AddressInformation existsAddressPostfix() {
            return AddressInformation
                    .builder()
                    .withSimpleAddressInformation(SimpleAddressInformationTest.SimpleAddressInformationMock.existsPostalCode())
                    .withAddressPostfix(AddressPostfix.of("1-2-3"))
                    .build();
        }
    }


}
