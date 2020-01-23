package org.venuspj.ddd.model.repository.criteria;

import java.util.function.Predicate;

public interface Criteria<E> extends Predicate<E> {

    boolean test(E value);

    void valueChanged();

    boolean isPresent();
}
