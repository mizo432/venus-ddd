package org.venuspj.ddd.model.value;

public interface LongValue<L extends LongValue<L>> extends Value<L> {
    Long asLong();

    String asText();

    Long getValue();

}
