package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.primitives.code.AbstractStringCodeValue;

/**
 * 住所コード.
 */
public class AddressCode extends AbstractStringCodeValue<AddressCode> {

    public AddressCode(String aValue) {
        super(aValue);

    }

    public AddressCode() {
        super();
    }

    public static AddressCode of(String aValue) {
        return new AddressCode(aValue);

    }


    public static AddressCode empty() {
        return new AddressCode();
    }
}
