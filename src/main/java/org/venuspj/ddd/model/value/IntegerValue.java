package org.venuspj.ddd.model.value;

public interface IntegerValue<T extends IntegerValue<T>> extends Value<T> {
    Integer asInteger();

    String asText();

}
