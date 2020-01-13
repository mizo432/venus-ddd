package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractComparableSingleValue;

/**
 * @param <ADV>
 */
public class AbstractDoubleValue<ADV extends AbstractDoubleValue<ADV>>
        extends AbstractComparableSingleValue<Double, ADV> implements DoubleValue<ADV> {

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
