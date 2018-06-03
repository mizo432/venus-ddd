package org.venuspj.ddd.model.specification.basic;

import com.google.common.collect.ComparisonChain;
import org.venuspj.ddd.model.specification.ValueBoundSpecification;

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
