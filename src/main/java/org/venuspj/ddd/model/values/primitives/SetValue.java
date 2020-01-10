package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.Value;

import java.util.Iterator;
import java.util.Set;

public interface SetValue<E, SV extends SetValue<E, SV>> extends Iterable<E>, Value<SV> {

    Set<E> asSet();

    Iterator<E> iterator();

    Set<E> getValue();

}


