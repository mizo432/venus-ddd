package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.primitives.code.AbstractStringCodeValue;

public class AddressBarCode extends AbstractStringCodeValue<AddressBarCode> {

    public AddressBarCode(String aValue) {
        super(aValue);

    }

    public AddressBarCode() {
        super();
    }

    public static AddressBarCode of(String aValue) {
        return new AddressBarCode(aValue);

    }


    public static AddressBarCode empty() {
        return new AddressBarCode();

    }
}
