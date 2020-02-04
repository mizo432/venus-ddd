package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.primitives.AbstractIntegerValue;

import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * 日数.
 */
public class Days extends AbstractIntegerValue<Days> {

    public Days(Integer aValue) {
        super(aValue);
    }

    public Days() {

    }

    public static Days of(Integer aValue) {
        return new Days(aValue);
    }

    public static Days empty() {
        return new Days();
    }

    public boolean isEmpty() {
        return isNull(value);
    }
}
