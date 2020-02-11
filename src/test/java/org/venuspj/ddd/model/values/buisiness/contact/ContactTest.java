package org.venuspj.ddd.model.values.buisiness.contact;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.json.JsonMapperEx;
import org.venuspj.ddd.model.values.buisiness.address.AddressInformation;
import org.venuspj.ddd.model.values.buisiness.address.SimpleAddressInformation;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class ContactTest {
    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        Contact target = Contact.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        Contact target = Contact.of(AddressInformation.empty(),
                EmailAddress.empty(), TelephoneNumber.empty(), TelephoneNumber.empty());

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void builder1() {
        Contact target = Contact
                .builder()
                .withAddressInformation(AddressInformation.empty())
                .withEmailAddress(EmailAddress.empty())
                .withTelephoneNumber(TelephoneNumber.empty())
                .withFaxNumber(TelephoneNumber.empty())
                .build();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void builder2() {
        Contact target = Contact
                .builder()
                .withAddressInformation(null)
                .withEmailAddress(null)
                .withTelephoneNumber(null)
                .withFaxNumber(null)
                .build();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void builder3() {
        Contact target = Contact
                .builder()
                .apply(Contact.empty());

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs1() {
        Contact target = Contact.empty();

        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs2() {
        Contact target = Contact.empty();

        boolean actual = target.sameValueAs(null);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs3() {
        Contact arg = Contact.empty();
        Contact target = Contact.empty();

        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void toString1() {
        Contact target = Contact.empty();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void equals1() {
        SimpleAddressInformation arg = SimpleAddressInformation.empty();
        Contact target = Contact.empty();
        boolean actual = target.equals(arg);
        assertThat(actual)
                .isFalse();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty1() {
        SimpleAddressInformation arg = SimpleAddressInformation.empty();
        Contact target = Contact.empty();
        boolean actual = target.isEmpty();
        assertThat(actual)
                .isTrue();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty2() {
        SimpleAddressInformation arg = SimpleAddressInformation.empty();
        Contact target = ContactMock.empty();
        boolean actual = target.isEmpty();
        assertThat(actual)
                .isTrue();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty4() {
        Contact target = ContactMock.existTelephoneNumber();
        boolean actual = target.isEmpty();
        assertThat(actual)
                .isFalse();


    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty5() {
        Contact target = ContactMock.existFaxNumber();
        boolean actual = target.isEmpty();
        assertThat(actual)
                .isFalse();


    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty6() {
        Contact target = ContactMock.existEmailAddress();
        boolean actual = target.isEmpty();
        assertThat(actual)
                .isFalse();


    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson1() throws JsonProcessingException {
        Contact target = ContactMock.full();
        JsonMapperEx objectMapper = new JsonMapperEx();

        String json = objectMapper.writeValueAsString(target);

        Contact actual = objectMapper.readValue(json, Contact.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson2() throws JsonProcessingException {
        Contact target = Contact.empty();
        JsonMapperEx objectMapper = new JsonMapperEx();

        String json = objectMapper.writeValueAsString(target);

        Contact actual = objectMapper.readValue(json, Contact.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    private static class ContactMock {
        public static Contact empty() {
            return Contact.builder().build();
        }

        public static Contact existTelephoneNumber() {
            return Contact.builder()
                    .withTelephoneNumber(TelephoneNumber.of("012-3456-7890"))
                    .build();
        }

        public static Contact existFaxNumber() {
            return Contact.builder()
                    .withFaxNumber(TelephoneNumber.of("012-3456-7890"))
                    .build();
        }

        public static Contact existEmailAddress() {
            return Contact.builder()
                    .withEmailAddress(EmailAddress.of("dummy.@gmail.com"))
                    .build();
        }

        public static Contact full() {
            return Contact.builder()
//                    .withAddressInformation(AddressInformationTest.AddressInformationMock.one())
                    .withTelephoneNumber(TelephoneNumber.of("012-3456-7890"))
                    .withFaxNumber(TelephoneNumber.of("012-3456-7890"))
                    .withEmailAddress(EmailAddress.of("dummy.@gmail.com"))
                    .build();
        }
    }
}
