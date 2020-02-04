package org.venuspj.ddd.model.values.buisiness.contact;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.address.Address;
import org.venuspj.ddd.model.values.buisiness.contact.email.EmailAddress;
import org.venuspj.ddd.model.values.buisiness.contact.telephone.TelephoneNumber;
import org.venuspj.util.objects2.Objects2;

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

    @Override
    public int hashCode() {
        return Objects2.hash(address, emailAddress, telephoneNumber, faxNumber);

    }

    public static Contact empty() {
        return new Contact();
    }


}
