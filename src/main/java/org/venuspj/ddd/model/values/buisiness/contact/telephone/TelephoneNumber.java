package org.venuspj.ddd.model.values.buisiness.contact.telephone;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

public class TelephoneNumber extends AbstractStringValue<TelephoneNumber> {
    public TelephoneNumber(String aValue) {
        super(aValue);
    }

    public TelephoneNumber() {

    }

    public static TelephoneNumber empty() {
        return new TelephoneNumber();

    }

    public static TelephoneNumber of(String aValue) {
        return new TelephoneNumber(aValue);
    }

}
