package org.venuspj.ddd.model.value;

public interface DoubleValue<DV extends DoubleValue<DV>> extends Value<DV> {
    Double asDouble();

    String asText();

    Double getValue();
}
