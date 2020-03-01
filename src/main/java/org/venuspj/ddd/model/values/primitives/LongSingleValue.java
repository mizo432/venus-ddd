package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

public interface LongSingleValue<L extends LongSingleValue<L>> extends SingleValue<Long, L> {
    Long asLong();

    String asText();

    Long getValue();

}
