package org.venuspj.ddd.model.values.buisiness.contact;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

public class EmailAddress extends AbstractStringValue<EmailAddress> {
    public EmailAddress(String aValue) {
        super(aValue);
    }

    public EmailAddress() {

    }

    public static EmailAddress empty() {
        return new EmailAddress();

    }

    public static EmailAddress of(String aValue) {
        return new EmailAddress(aValue);
    }
}
