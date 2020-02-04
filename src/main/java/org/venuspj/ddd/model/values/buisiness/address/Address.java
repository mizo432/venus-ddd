package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * 住所.
 */
public class Address extends AbstractEntity<Address, AddressIdentifier> {
    private AddressInformation addressInformation;

    Address(AddressIdentifier anAddressIdentifier, AddressInformation anAddressInformation) {
        super(anAddressIdentifier);
        addressInformation = anAddressInformation;
    }

    public Address() {
        addressInformation = AddressInformation.empty();
    }

    public static Address of(AddressIdentifier anAddressIdentifier, AddressInformation anAddressInformation) {
        return new Address(anAddressIdentifier, anAddressInformation);

    }

    public static Address empty() {
        return new Address();
    }

    @Override
    public boolean sameValueAs(Address other) {
        if (isNull(other))
            return false;

        return sameIdentifierAs(other) &&
                equal(addressInformation, other.addressInformation);
    }

    public boolean isEmpty() {
        return addressInformation.isEmpty();
    }
}
