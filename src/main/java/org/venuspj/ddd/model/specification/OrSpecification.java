package org.venuspj.ddd.model.specification;

public class OrSpecification<T> extends CompositSpecification<T> {
    public OrSpecification(Specification<T> lhs, Specification<T> rhs) {
        super(lhs, rhs);
    }

    @Override
    public boolean isSatisfiedBy(T candidate) {
        return lhs.isSatisfiedBy(candidate) || rhs.isSatisfiedBy(candidate);
    }
}
