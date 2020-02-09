package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

public interface DoubleValue<DV extends DoubleValue<DV>> extends SingleValue<Double, DV> {
    Double asDouble();

    String asText();

    Double getValue();
}
