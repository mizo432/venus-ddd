package org.venuspj.ddd.model.criterias.predicates;

import java.util.function.Predicate;

import static org.venuspj.util.objects2.Objects2.isNull;


public class EqualToPredicate<V> implements Predicate<V> {
    private V referenceValue;

    private EqualToPredicate() {

    }

    @Override
    public boolean test(V aValue) {
        return isNull(referenceValue) || referenceValue.equals(aValue);

    }

    public static <V> EqualToPredicate<V> of(V aReferenceValue) {
        EqualToPredicate<V> result = new EqualToPredicate<>();
        result.referenceValue = aReferenceValue;

        return result;
    }

}
