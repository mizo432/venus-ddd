package org.venuspj.ddd.model.specification.basic;

import org.venuspj.ddd.model.specification.ValueBoundSpecification;
import org.venuspj.util.objects2.Objects2;

public class EqualitySpecification <T> extends ValueBoundSpecification<T> {

    /**
     * @param property expression of the property being checked
     * @param value the value that our property should be equal to
     */
    public EqualitySpecification(String property, Object value) {
        super(property, value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected boolean isSatisfyingValue(Object candidateValue) {
        return Objects2.equal(candidateValue, value());
    }

}
