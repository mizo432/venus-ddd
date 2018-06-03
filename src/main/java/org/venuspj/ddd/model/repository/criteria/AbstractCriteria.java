package org.venuspj.ddd.model.repository.criteria;

public abstract class AbstractCriteria<E> implements Criteria<E> {
    Criteria<?> parent;
    protected boolean isEmpty;

    public AbstractCriteria(Criteria<?> parent) {
        this.parent = parent;
    }

    public boolean isEmpty(){
        return isEmpty;
    }

}
