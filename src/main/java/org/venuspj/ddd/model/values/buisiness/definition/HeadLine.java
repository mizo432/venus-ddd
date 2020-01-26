package org.venuspj.ddd.model.values.buisiness.definition;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

/**
 * 一行のテキスト.
 *
 * <pre>
 *     文字系列の値オブジェクト
 * </pre>
 */
public class HeadLine extends AbstractStringValue<HeadLine> {

    public HeadLine(String aValue) {
        super(aValue);
    }

    public HeadLine() {

    }

    public static HeadLine of(String aValue) {
        return new HeadLine(aValue);
    }

    public static HeadLine empty() {
        return new HeadLine();

    }
}