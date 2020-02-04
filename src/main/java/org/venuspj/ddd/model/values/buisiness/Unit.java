package org.venuspj.ddd.model.values.buisiness;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

/**
 * 単位
 */
public class Unit extends AbstractStringValue<Unit> {
    public Unit(String aValue) {
        super(aValue);
    }

    public Unit() {

    }

    public static Unit empty() {
        return new Unit();

    }

    public static Unit of(String aValue) {
        return new Unit(aValue);
    }
}
