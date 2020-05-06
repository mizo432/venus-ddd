package org.venuspj.ddd.model.criterias.predicates;

import java.util.function.Predicate;

import static org.venuspj.util.objects2.Objects2.isNull;

public class NotEqualToPredicate<V> implements Predicate<V> {
    private V referenceValue;

    private NotEqualToPredicate() {

    }

    @Override
    public boolean test(V aValue) {
        return isNull(referenceValue) || !referenceValue.equals(aValue);

    }

    public static <V> NotEqualToPredicate<V> of(V aReferenceValue) {
        NotEqualToPredicate<V> result = new NotEqualToPredicate<>();
        result.referenceValue = aReferenceValue;

        return result;
    }
}
