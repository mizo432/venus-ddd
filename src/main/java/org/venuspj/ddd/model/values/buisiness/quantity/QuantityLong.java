package org.venuspj.ddd.model.values.buisiness.quantity;

import org.venuspj.ddd.model.values.primitives.AbstractLongValue;

public class QuantityLong extends AbstractLongValue<QuantityLong> {

    public QuantityLong(Long aValue) {
        super(aValue);

    }

    public QuantityLong() {
        super();
    }

    public static QuantityLong of(Long aValue) {
        return new QuantityLong(aValue);

    }

    public static QuantityLong empty() {
        return new QuantityLong();

    }
}
