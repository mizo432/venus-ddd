package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;

public class IsEqualToCriteria<T> extends AbstractExpressionCriteria<T> {

    private T value;

    public IsEqualToCriteria() {
        super();

    }

    public IsEqualToCriteria(AbstractCriteria<?> aParentCriteria) {
        super(aParentCriteria);
    }

    public IsEqualToCriteria<T> setValue(T value) {
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
