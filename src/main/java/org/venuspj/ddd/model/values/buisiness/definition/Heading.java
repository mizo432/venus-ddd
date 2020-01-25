package org.venuspj.ddd.model.values.buisiness.definition;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

/**
 * 一行のテキスト.
 *
 * <pre>
 *     文字系列の値オブジェクト
 * </pre>
 */
public class Heading extends AbstractStringValue<Heading> {

    public Heading(String aValue) {
        super(aValue);
    }

    public Heading() {

    }

    public static Heading of(String aValue) {
        return new Heading(aValue);
    }

    public static Heading empty() {
        return new Heading();

    }
}
