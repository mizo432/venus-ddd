package org.venuspj.ddd.model.values.buisiness.name;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

/**
 * 名称.
 *
 * <pre>
 *     文字列系の値オブジェクト
 * </pre>
 */
public class Name extends AbstractStringValue<Name> {
    public Name(String aValue) {
        super(aValue);

    }

    public Name() {

    }

    public static Name of(String aValue) {
        return new Name(aValue);

    }

    public static Name empty() {
        return new Name();
    }
}
