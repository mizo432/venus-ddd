package org.venuspj.ddd.model.values.buisiness.hours;

import org.venuspj.ddd.model.values.primitives.AbstractIntegerValue;

/**
 * 時間数
 */
public class Hours extends AbstractIntegerValue<Hours> {

    Hours(Integer aValue) {
        super(aValue);
    }

    public Hours() {

    }

    public static Hours empty() {
        return new Hours();
    }

    public static Hours of(Integer aValue) {
        return new Hours(aValue);
    }

    public static Hours zero() {
        return of(0);
    }
}
