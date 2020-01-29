package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

public class AddressPostfix extends AbstractStringValue<AddressPostfix> {

    public AddressPostfix(String aValue) {
        super(aValue);
    }

    public AddressPostfix() {

    }

    public static AddressPostfix empty() {
        return new AddressPostfix();

    }

    public static AddressPostfix of(String aValue) {
        return new AddressPostfix(aValue);

    }

}
