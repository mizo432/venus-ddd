package org.venuspj.ddd.model.specification;

public class AndSpecification<T> extends ComposableSpecification<T> {

    protected AndSpecification(Specification<T> aLhs, Specification<T> aRhs) {
        super(aLhs, aRhs);
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return lhs.isSatisfiedBy(candidate) && rhs.isSatisfiedBy(candidate);
    }
}
