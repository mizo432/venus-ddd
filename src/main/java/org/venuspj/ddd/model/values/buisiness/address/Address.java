package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;

/**
 * 住所.
 */
public class Address extends AbstractEntity<Address, AddressIdentifier, SimpleAddressInformation> {

    Address(AddressIdentifier anAddressIdentifier, SimpleAddressInformation anAddressInformation) {
        super(anAddressIdentifier, anAddressInformation);
    }

    public Address() {
        super(AddressIdentifier.empty(), SimpleAddressInformation.empty());

    }

    public static Address of(AddressIdentifier anAddressIdentifier, SimpleAddressInformation anAddressInformation) {
        return new Address(anAddressIdentifier, anAddressInformation);

    }

    public static Address empty() {
        return new Address();

    }

    protected SimpleAddressInformation getAddressInformation() {
        return getEntityInfo();

    }

}
