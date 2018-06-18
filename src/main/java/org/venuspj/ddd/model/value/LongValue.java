package org.venuspj.ddd.model.value;

public interface LongValue<T extends LongValue<T>> extends Value<T> {
    Long asLong();

    String asText();

}
