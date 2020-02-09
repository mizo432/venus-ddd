package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

public interface LongValue<ISV extends LongValue<ISV>> extends SingleValue<Long, ISV> {

    Long asInteger();

    String asText();

    Long getValue();

}
