package org.venuspj.ddd.model.specification;

public interface Specification<T> {
    boolean isSatisfiedBy(T aCandidate);

    default Specification<T> and(Specification<T> rhs) {
        return new AndSpecification<T>(this, rhs);

    }

    default Specification<T> or(Specification<T> rhs) {
        return new OrSpecification<T>(this, rhs);

    }

    default Specification<T> not() {
        return new NotSpecification<T>(this);

    }
}
