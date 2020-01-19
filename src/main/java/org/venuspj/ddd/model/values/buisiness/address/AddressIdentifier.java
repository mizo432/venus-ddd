package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class AddressIdentifier extends AbstractEntityLongIdentifier<Address, AddressIdentifier> {

    public AddressIdentifier(Long aValue) {
        super(Address.class, aValue);
    }

    @Override
    public boolean sameValueAs(AddressIdentifier other) {
        if (this == other) return true;
        return equal(this.kind, other.kind)
                && equal(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (isNull(o) || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AddressIdentifier that = (AddressIdentifier) o;
        return sameValueAs(that);
    }

}
