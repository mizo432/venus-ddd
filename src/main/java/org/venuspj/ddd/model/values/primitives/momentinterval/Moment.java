package org.venuspj.ddd.model.values.primitives.momentinterval;

public interface Moment<M> {

    boolean isEmpty();

    Comparable<M> comparable();

    M getValue();

}
