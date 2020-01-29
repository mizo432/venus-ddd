package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

public class GreaterOrEqualCriteria<T extends Comparable<T>> extends AbstractExpressionCriteria<T> {
    @Override
    public boolean test(T value) {
        return false;
    }
}
