package org.venuspj.ddd.model.criterias.predicates;


import org.venuspj.util.strings2.Strings2;

import java.util.function.Predicate;

import static org.venuspj.util.objects2.Objects2.isNull;


public class ForwardMatchPredicate implements Predicate<String> {
    private String referenceValue;

    public static ForwardMatchPredicate of(String aForwardMatch) {
        ForwardMatchPredicate result = new ForwardMatchPredicate();
        result.referenceValue = aForwardMatch;
        return result;

    }

    @Override
    public boolean test(String aValue) {
        if (isNull(referenceValue)) return true;
        if (isNull(aValue)) return false;
        return Strings2.startsWith(aValue, referenceValue);
    }
}
