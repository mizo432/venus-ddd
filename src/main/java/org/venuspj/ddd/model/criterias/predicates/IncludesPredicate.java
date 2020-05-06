package org.venuspj.ddd.model.criterias.predicates;

import java.util.List;
import java.util.function.Predicate;

import static org.venuspj.util.collect.Lists2.newArrayList;
import static org.venuspj.util.objects2.Objects2.isNull;


public class IncludesPredicate<C> implements Predicate<C> {
    private List<C> referenceValue = newArrayList();

    public static <C> IncludesPredicate<C> of(List<C> aReferenceValues) {
        IncludesPredicate<C> result = new IncludesPredicate<>();
        result.referenceValue.addAll(aReferenceValues);
        return result;

    }

    @Override
    public boolean test(C aValue) {
        if (isNull(referenceValue)) return true;
        if (referenceValue.isEmpty()) return true;
        if (isNull(aValue)) return false;
        return referenceValue.contains(aValue);

    }
}
