package org.venuspj.ddd.model.repository.criteria;

import java.util.Optional;

public abstract class AbstractCriteria<E> implements Criteria<E> {

    protected Optional<Criteria<?>> parentCriteriaOptional = Optional.empty(); //NOPMD

    protected Boolean isEmpty = Boolean.TRUE;

    protected AbstractCriteria(Criteria<?> parent) {
        this.parentCriteriaOptional = Optional.of(parent);
    }

    protected AbstractCriteria() {
    }

    public boolean isEmpty() {
        return isEmpty;

    }

    public void valueChanged() {
        if (parentCriteriaOptional.isPresent()) getParentCriteriaOptional().valueChanged();
        isEmpty = Boolean.FALSE;

    }

    private Criteria<?> getParentCriteriaOptional() {
        return parentCriteriaOptional.get();
    }


    public boolean isPresent() {
        return !isEmpty;

    }

    @SuppressWarnings("unchecked")
    protected <Value> boolean testChildren(Value value, Criteria<Value>... criteriaArray) {
        for (Criteria<Value> criteria : criteriaArray) {
            if (criteria.isPresent() && !criteria.test(value))
                return false;
        }
        return true;

    }
}
