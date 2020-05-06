package org.venuspj.ddd.model.criterias.predicates;

import java.util.function.Predicate;

import static org.venuspj.util.base.Preconditions.checkArgument;
import static org.venuspj.util.objects2.Objects2.isNull;
import static org.venuspj.util.objects2.Objects2.nonNull;

public class BetweenPredicate<C extends Comparable<C>> implements Predicate<C> {
    private C fromValue;
    private C toValue;

    public static <C extends Comparable<C>> BetweenPredicate<C> of(C aFromValue, C aToValue) {
        checkArgument((nonNull(aFromValue) && nonNull(aToValue) || (isNull(aFromValue) && isNull(aToValue))),
                () -> new IllegalArgumentException());
        BetweenPredicate<C> result = new BetweenPredicate<>();
        result.fromValue = aFromValue;
        result.toValue = aToValue;
        return result;
    }

    @Override
    public boolean test(C aValue) {
        if (isNull(fromValue) && isNull(toValue)) return true;
        if (isNull(aValue)) return false;
        if (nonNull(fromValue) && fromValue.compareTo(aValue) > 0) return false;
        return isNull(toValue) || toValue.compareTo(aValue) >= 0;
    }
}
