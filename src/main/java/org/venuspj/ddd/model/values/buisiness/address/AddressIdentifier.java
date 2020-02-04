package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public class AddressIdentifier extends AbstractEntityLongIdentifier<Address, AddressIdentifier> {

    public AddressIdentifier(Long aValue) {
        super(Address.class, aValue);
    }

    public AddressIdentifier() {
        super(Address.class);
    }

    public static AddressIdentifier empty() {
        return new AddressIdentifier();
    }

    public static AddressIdentifier of(Long aValue) {
        return new AddressIdentifier(aValue);
    }

    @Override
    public boolean sameValueAs(AddressIdentifier other) {
        return equals(other);
    }

}
