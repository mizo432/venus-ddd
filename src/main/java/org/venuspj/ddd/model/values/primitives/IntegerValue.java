package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

public interface IntegerValue<ISV extends IntegerValue<ISV>> extends SingleValue<Integer, ISV> {

    Integer asInteger();

    String asText();

    Integer getValue();

}
