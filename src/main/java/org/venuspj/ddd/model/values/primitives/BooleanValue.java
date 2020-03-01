package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

public interface BooleanValue<BV extends BooleanValue<BV>> extends SingleValue<Boolean, BV> {
    Boolean asBoolean();

    Boolean getValue();

}
