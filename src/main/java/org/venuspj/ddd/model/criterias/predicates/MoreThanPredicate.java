package org.venuspj.ddd.model.criterias.predicates;

import java.util.function.Predicate;

import static org.venuspj.util.objects2.Objects2.nonNull;

public class MoreThanPredicate<C extends Comparable<C>> implements Predicate<C> {
    private C referenceValue;

    public static <C extends Comparable<C>> MoreThanPredicate<C> of(C aReferenceValue) {
        MoreThanPredicate<C> result = new MoreThanPredicate<>();
        result.referenceValue = aReferenceValue;
        return result;

    }

    @Override
    public boolean test(C aValue) {
        return !nonNull(referenceValue) || referenceValue.compareTo(aValue) < 0;

    }
}
