package org.venuspj.ddd.model.specification;

public abstract class ComposableSpecification<T> implements Specification<T> {
    protected final Specification<T> lhs;
    protected final Specification<T> rhs;

    protected ComposableSpecification(Specification<T> aLhs, Specification<T> aRhs) {
        lhs = aLhs;
        rhs = aRhs;
    }

    public Specification<T> lhs() {
        return lhs;
    }

    public Specification<T> rhs() {
        return rhs;
    }

}
