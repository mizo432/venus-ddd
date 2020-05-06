package org.venuspj.ddd.model.criterias.predicates;

import java.util.function.Predicate;

import static org.venuspj.util.objects2.Objects2.isNull;
import static org.venuspj.util.objects2.Objects2.nonNull;

public class IsNullPredicate<V> implements Predicate<V> {
    private Boolean referenceValue;

    private IsNullPredicate() {

    }

    @Override
    public boolean test(V aValue) {
        return !nonNull(referenceValue) || !referenceValue || isNull(aValue);

    }

    public static <V> IsNullPredicate<V> of(Boolean aReferenceValue) {
        IsNullPredicate<V> result = new IsNullPredicate<>();
        result.referenceValue = aReferenceValue;

        return result;
    }
}
