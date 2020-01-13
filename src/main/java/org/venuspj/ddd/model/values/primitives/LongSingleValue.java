package org.venuspj.ddd.model.values.primitives;

public interface LongSingleValue<L extends LongSingleValue<L>> extends SingleValue<Long, L> {
    Long asLong();

    String asText();

    Long getValue();

}
