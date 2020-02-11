package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;

/**
 * 住所.
 */
public class Address extends AbstractEntity<Address, AddressIdentifier> {

    Address(AddressIdentifier anAddressIdentifier) {
        super(anAddressIdentifier);
    }

    public Address() {
        super(AddressIdentifier.empty());

    }

    public static Address of(AddressIdentifier anAddressIdentifier) {
        return new Address(anAddressIdentifier);

    }

    public static Address empty() {
        return new Address();

    }

}
