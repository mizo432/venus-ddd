package org.venuspj.ddd.model.value;

import static org.venuspj.util.objects2.Objects2.equal;

public abstract class AbstractDoubleValue<ASV extends AbstractDoubleValue<ASV>>
        extends AbstractSingleValue<ASV, Double> implements DoubleValue<ASV> {

    protected AbstractDoubleValue() {
        super();
    }

    protected AbstractDoubleValue(Double value) {
        super(value);

    }

    @Override
    public Double asDouble() {
        return value;
    }

    @Override
    public String asText() {
        return value.toString();
    }

}
