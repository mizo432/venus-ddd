package org.venuspj.ddd.model.specification;

public class NotSpecification<T> implements Specification<T> {
    private Specification<T> proposition;

    public NotSpecification(Specification<T> aProposition) {
        proposition = aProposition;
    }

    @Override
    public boolean isSatisfiedBy(T aCandidate) {
        return !proposition.isSatisfiedBy(aCandidate);
    }
}
