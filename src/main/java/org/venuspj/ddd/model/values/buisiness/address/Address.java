package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;

/**
 * 住所.
 */
public class Address extends AbstractEntity<Address, AddressIdentifier, AddressInformation> {

    Address(AddressIdentifier anAddressIdentifier, AddressInformation anAddressInformation) {
        super(anAddressIdentifier, anAddressInformation);
    }

    public Address() {
        super(AddressIdentifier.empty(), AddressInformation.empty());

    }

    public static Address of(AddressIdentifier anAddressIdentifier, AddressInformation anAddressInformation) {
        return new Address(anAddressIdentifier, anAddressInformation);

    }

    public static Address empty() {
        return new Address();
    }

    public boolean isEmpty() {
        return getEntityInfo().isEmpty()
                && getAddressInformation().isEmpty();
    }

    protected AddressInformation getAddressInformation() {
        return getEntityInfo();

    }

}
