package org.venuspj.ddd.model.criterias;

import java.util.function.Predicate;

public interface Criteria<E> extends Predicate<E> {

    boolean test(E value);

}
