package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.primitives.code.AbstractStringCodeValue;

/**
 * 郵便番号.
 */
public class ZipCode extends AbstractStringCodeValue<ZipCode> {

    public ZipCode(String aValue) {
        super(aValue);
    }

    public ZipCode() {
    }

    public static ZipCode empty() {
        return new ZipCode();
    }

    public static ZipCode of(String aValue) {
        return new ZipCode(aValue);
    }

}
