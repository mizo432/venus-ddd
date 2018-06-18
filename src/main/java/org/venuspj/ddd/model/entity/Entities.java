package org.venuspj.ddd.model.entity;

import java.util.List;

public interface Entities<E extends Entity<E, ?>> {

    List<E> asList();

    Integer size();

    Boolean isEmpty();

    boolean contains(E t);
}
