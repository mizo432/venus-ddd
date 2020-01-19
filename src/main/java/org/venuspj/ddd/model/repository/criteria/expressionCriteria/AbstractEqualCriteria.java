package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

import org.venuspj.ddd.model.repository.criteria.Criteria;

public class AbstractEqualCriteria<T> extends AbstractExpressionCriteria<T> {

    private T value;

    public AbstractEqualCriteria(Criteria<?> criteria) {
        super(criteria);

    }

    public AbstractEqualCriteria<T> setValue(T value) {
        this.value = value;
        valueChanged();
        return this;
    }

    public T getValue() {
        return value;

    }

    @Override
    public boolean test(T value) {
        return isEmpty || this.value.equals(value);

    }

}
