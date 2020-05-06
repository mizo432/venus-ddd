package org.venuspj.ddd.model.criterias.predicates;

import java.util.function.Predicate;

import static org.venuspj.util.objects2.Objects2.nonNull;

public class IsNotNullPredicate<V> implements Predicate<V> {
    private Boolean referenceValue;

    private IsNotNullPredicate() {

    }

    @Override
    public boolean test(V aValue) {
        return !nonNull(referenceValue) || !referenceValue || nonNull(aValue);

    }

    public static <V> IsNotNullPredicate<V> of(Boolean aReferenceValue) {
        IsNotNullPredicate<V> result = new IsNotNullPredicate<>();
        result.referenceValue = aReferenceValue;

        return result;
    }
}
