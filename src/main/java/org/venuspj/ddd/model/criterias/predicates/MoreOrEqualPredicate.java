package org.venuspj.ddd.model.criterias.predicates;

import java.util.function.Predicate;

import static org.venuspj.util.objects2.Objects2.isNull;

public class MoreOrEqualPredicate<C extends Comparable<C>> implements Predicate<C> {
    private C referenceValue;

    public static <C extends Comparable<C>> MoreOrEqualPredicate<C> of(C aReferenceValue) {
        MoreOrEqualPredicate<C> result = new MoreOrEqualPredicate<>();
        result.referenceValue = aReferenceValue;
        return result;

    }

    @Override
    public boolean test(C aValue) {
        return isNull(referenceValue) || referenceValue.compareTo(aValue) <= 0;

    }
}
