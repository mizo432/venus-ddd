package org.venuspj.ddd.model.values.primitives;

public interface BooleanValue<BV extends BooleanValue<BV>> extends SingleValue<Boolean, BV> {
    Boolean asBoolean();

    Boolean getValue();

}
