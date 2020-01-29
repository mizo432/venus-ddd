package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

public class SmallerCriteria<T extends Comparable<T>> extends AbstractExpressionCriteria<T> {
    @Override
    public boolean test(T value) {
        return false;
    }
}
