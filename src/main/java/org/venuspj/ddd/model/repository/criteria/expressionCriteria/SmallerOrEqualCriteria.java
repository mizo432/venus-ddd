package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

public class SmallerOrEqualCriteria<T extends Comparable<T>> extends AbstractExpressionCriteria<T> {

    @Override
    public boolean test(T value) {
        return false;
    }
}
