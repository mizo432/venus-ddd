package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;

import java.util.ArrayList;
import java.util.Collection;

import static org.venuspj.util.collect.Lists2.newArrayList;

public class IncludeCriteria<T> extends AbstractExpressionCriteria<T> {

    private ArrayList<T> value = newArrayList();

    public IncludeCriteria() {
        super();

    }

    public IncludeCriteria(AbstractCriteria<?> aParentCriteria) {
        super(aParentCriteria);
    }

    public IncludeCriteria<T> setValue(Collection<T> aCollection) {
        value.addAll(aCollection);
        valueChanged();
        return this;
    }

    public ArrayList<T> getValue() {
        return value;

    }

    @Override
    public boolean test(T value) {
        return isEmpty
                || this.value.contains(value);

    }
}
