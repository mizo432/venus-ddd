package org.venuspj.ddd.model.values.buisiness.note;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

/**
 * 一行のテキスト.
 *
 * <pre>
 *     文字系列の値オブジェクト
 * </pre>
 */
public class Line extends AbstractStringValue<Line> {

    public Line(String aValue) {
        super(aValue);
    }

    public static Line of(String aValue) {
        return new Line(aValue);
    }

}
