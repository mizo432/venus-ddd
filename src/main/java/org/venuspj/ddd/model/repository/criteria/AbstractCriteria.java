package org.venuspj.ddd.model.repository.criteria;

import static org.venuspj.util.objects2.Objects2.nonNull;

public abstract class AbstractCriteria<E> implements Criteria<E> {
    protected Criteria<?> parent;
    protected Boolean isEmpty = Boolean.TRUE;

    public AbstractCriteria(Criteria<?> parent) {
        this.parent = parent;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void valueChanged() {
        if (nonNull(parent)) parent.valueChanged();
        isEmpty = Boolean.FALSE;

    }


    public boolean isPresent() {
        return !isEmpty;
    }
}
