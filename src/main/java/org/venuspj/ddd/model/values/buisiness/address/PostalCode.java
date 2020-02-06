package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.primitives.code.AbstractStringCodeValue;

/**
 * 郵便番号.
 */
public class PostalCode extends AbstractStringCodeValue<PostalCode> {

    public PostalCode(String aValue) {
        super(aValue);
    }

    public PostalCode() {
    }

    public static PostalCode empty() {
        return new PostalCode();
    }

    public static PostalCode of(String aValue) {
        return new PostalCode(aValue);
    }

}
