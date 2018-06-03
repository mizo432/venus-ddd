package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

import org.venuspj.ddd.model.repository.criteria.Criteria;

public class EqualCriteria<T> extends ExpressionCriteria<T> {
    T value;
    boolean isEmpty;

    public EqualCriteria(Criteria<?> criteria) {
        super(criteria);
    }

    @Override
    public boolean test(T value) {
        return isEmpty || this.value.equals(value);
    }

}
