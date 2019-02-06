package org.venuspj.ddd.model.specification.basic;

import org.venuspj.ddd.model.specification.ValueBoundSpecification;
import org.venuspj.util.collect.ComparisonChain;

public abstract class CompareToSpecification<T> extends ValueBoundSpecification<T> {
    private final int expectedComparison;

    public CompareToSpecification(String property, Object value, int expectedComparison) {
        super(property, value);
        this.expectedComparison = expectedComparison;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected final boolean isSatisfyingValue(Object candidateValue) {
        return ComparisonChain
                .start()
                .compare((Comparable) candidateValue, (Comparable) this.value())
                .result() == expectedComparison;
    }
}
