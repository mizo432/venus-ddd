package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

public class BetweenCriteria<T extends Comparable<T>> extends AbstractExpressionCriteria<T> {
    private GreaterOrEqualCriteria<T> greaterOrEqualCriteria;
    private SmallerOrEqualCriteria<T> smallerCriteria;

    @Override
    public boolean test(T value) {
        return greaterOrEqualCriteria.test(value) && smallerCriteria.test(value);

    }

}
