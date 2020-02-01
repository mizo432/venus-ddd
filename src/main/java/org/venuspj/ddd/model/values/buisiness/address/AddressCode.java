package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.buisiness.code.AbstractStringCodeValue;

public class AddressCode extends AbstractStringCodeValue<AddressCode> {

    public AddressCode(String aValue) {
        super(aValue);

    }

    public static AddressCode of(String aValue) {
        return new AddressCode(aValue);

    }


}
