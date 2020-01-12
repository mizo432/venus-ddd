package org.venuspj.ddd.model.repository.criteria;

import java.util.Optional;

public abstract class AbstractCriteria<E> implements Criteria<E> {

    protected Optional<Criteria<?>> criteriaOptional;

    protected Boolean isEmpty = Boolean.TRUE;

    protected AbstractCriteria(Criteria<?> parent) {
        this.criteriaOptional = Optional.of(parent);
    }

    protected AbstractCriteria() {
    }

    public boolean isEmpty() {
        return isEmpty;

    }

    public void valueChanged() {
        if (criteriaOptional.isPresent()) getCriteriaOptional().valueChanged();
        isEmpty = Boolean.FALSE;

    }

    private Criteria<?> getCriteriaOptional() {
        return criteriaOptional.get();
    }


    public boolean isPresent() {
        return !isEmpty;

    }
}
