package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

import org.venuspj.ddd.model.repository.criteria.Criteria;

public class EqualCriteriaAbstract<T> extends AbstractExpressionCriteria<T> {

    private T value;

    public EqualCriteriaAbstract(Criteria<?> criteria) {
        super(criteria);
    }

    public EqualCriteriaAbstract<T> setValue(T value) {
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
