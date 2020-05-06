package org.venuspj.ddd.model.values.buisiness.contact;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.address.Address;
import org.venuspj.util.builder.ObjectBuilder;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.isNull;

public class Contact implements Value<Contact> {
    private Address address = Address.empty();
    private EmailAddress emailAddress = EmailAddress.empty();
    private TelephoneNumber telephoneNumber = TelephoneNumber.empty();
    private TelephoneNumber faxNumber = TelephoneNumber.empty();

    Contact(Address anAddress, EmailAddress anEmailAddress, TelephoneNumber aTelephoneNumber, TelephoneNumber aFaxNumber) {
        address = anAddress;
        emailAddress = anEmailAddress;
        telephoneNumber = aTelephoneNumber;
        faxNumber = aFaxNumber;
    }

    public Contact() {

    }

    public static Contact of(Address anAddress, EmailAddress anEmailAddress, TelephoneNumber aTelephoneNumber, TelephoneNumber aFaxNumber) {
        return new Contact(anAddress, anEmailAddress, aTelephoneNumber, aFaxNumber);

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
        return Objects2.equal(address, contact.address) &&
                Objects2.equal(emailAddress, contact.emailAddress) &&
                Objects2.equal(telephoneNumber, contact.telephoneNumber) &&
                Objects2.equal(faxNumber, contact.faxNumber);

    }

    public Address getAddress() {
        return address;

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
        return Objects2.hash(address, emailAddress, telephoneNumber, faxNumber);

    }

    public static Contact empty() {
        return new Contact();
    }

    @Override
    public boolean isEmpty() {
        return address.isEmpty()
                && emailAddress.isEmpty()
                && telephoneNumber.isEmpty()
                && faxNumber.isEmpty();
    }

    public static class ContactBuilder extends ObjectBuilder<Contact, ContactBuilder> {
        private Address address = Address.empty();
        private EmailAddress emailAddress = EmailAddress.empty();
        private TelephoneNumber telephoneNumber = TelephoneNumber.empty();
        private TelephoneNumber faxNumber = TelephoneNumber.empty();

        @Override
        protected void apply(Contact vo, ContactBuilder builder) {
            builder.withAddress(vo.getAddress());
            builder.withEmailAddress(vo.getEmailAddress());
            builder.withTelephoneNumber(vo.getTelephoneNumber());
            builder.withFaxNumber(vo.getFaxNumber());


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

        public ContactBuilder withAddress(Address anAddress) {
            if (isNull(anAddress)) return getThis();
            addConfigurator(builder -> builder.address = anAddress);
            return getThis();
        }

        @Override
        protected Contact createValueObject() {
            return new Contact(address, emailAddress, telephoneNumber, faxNumber);
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
