package org.venuspj.ddd.model.values.buisiness.contact;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.address.AddressInformation;
import org.venuspj.util.builder.ObjectBuilder;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.isNull;
import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class Contact implements Value<Contact> {
    private AddressInformation addressInformation = AddressInformation.empty();
    private EmailAddress emailAddress = EmailAddress.empty();
    private TelephoneNumber telephoneNumber = TelephoneNumber.empty();
    private TelephoneNumber faxNumber = TelephoneNumber.empty();

    Contact(AddressInformation anAddressInformation, EmailAddress anEmailAddress, TelephoneNumber aTelephoneNumber, TelephoneNumber aFaxNumber) {
        addressInformation = anAddressInformation;
        emailAddress = anEmailAddress;
        telephoneNumber = aTelephoneNumber;
        faxNumber = aFaxNumber;
    }

    public Contact() {

    }

    public static Contact of(AddressInformation anAddressInformation, EmailAddress anEmailAddress, TelephoneNumber aTelephoneNumber, TelephoneNumber aFaxNumber) {
        return new Contact(anAddressInformation, anEmailAddress, aTelephoneNumber, aFaxNumber);

    }

    public static ContactBuilder builder() {
        return new ContactBuilder();

    }

    @Override
    public boolean sameValueAs(Contact other) {
        return equals(other);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects2.equal(addressInformation, contact.addressInformation) &&
                Objects2.equal(emailAddress, contact.emailAddress) &&
                Objects2.equal(telephoneNumber, contact.telephoneNumber) &&
                Objects2.equal(faxNumber, contact.faxNumber);

    }

    public AddressInformation getAddressInformation() {
        return addressInformation;
    }

    public EmailAddress getEmailAddress() {
        return emailAddress;
    }

    public TelephoneNumber getTelephoneNumber() {
        return telephoneNumber;
    }

    public TelephoneNumber getFaxNumber() {
        return faxNumber;
    }

    @Override
    public int hashCode() {
        return Objects2.hash(addressInformation, emailAddress, telephoneNumber, faxNumber);

    }

    public static Contact empty() {
        return new Contact();
    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return addressInformation.isEmpty()
                && emailAddress.isEmpty()
                && telephoneNumber.isEmpty()
                && faxNumber.isEmpty();
    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();
    }

    public static class ContactBuilder extends ObjectBuilder<Contact, ContactBuilder> {
        private AddressInformation addressInformation = AddressInformation.empty();
        private EmailAddress emailAddress = EmailAddress.empty();
        private TelephoneNumber telephoneNumber = TelephoneNumber.empty();
        private TelephoneNumber faxNumber = TelephoneNumber.empty();

        @Override
        protected void apply(Contact vo, ContactBuilder builder) {
            builder.withAddressInformation(vo.addressInformation);
            builder.withEmailAddress(vo.emailAddress);
            builder.withTelephoneNumber(vo.telephoneNumber);
            builder.withFaxNumber(vo.faxNumber);


        }

        public ContactBuilder withFaxNumber(TelephoneNumber faxNumber) {
            if (isNull(faxNumber)) return getThis();
            addConfigurator(builder -> builder.faxNumber = faxNumber);
            return getThis();

        }

        public ContactBuilder withTelephoneNumber(TelephoneNumber telephoneNumber) {
            if (isNull(telephoneNumber)) return getThis();
            addConfigurator(builder -> builder.telephoneNumber = telephoneNumber);
            return getThis();

        }

        public ContactBuilder withEmailAddress(EmailAddress emailAddress) {
            if (isNull(emailAddress)) return getThis();
            addConfigurator(builder -> builder.emailAddress = emailAddress);
            return getThis();

        }

        public ContactBuilder withAddressInformation(AddressInformation addressInformation) {
            if (isNull(addressInformation)) return getThis();
            addConfigurator(builder -> builder.addressInformation = addressInformation);
            return getThis();
        }

        @Override
        protected Contact createValueObject() {
            return new Contact(addressInformation, emailAddress, telephoneNumber, faxNumber);
        }

        @Override
        protected ContactBuilder getThis() {
            return this;
        }

        @Override
        protected ContactBuilder newInstance() {
            return new ContactBuilder();
        }
    }


}
