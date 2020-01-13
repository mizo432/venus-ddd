package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.Value;

import java.util.Iterator;
import java.util.List;

public interface ListValue<E, LV extends ListValue<E, LV>> extends Iterable<E>, Value<LV> {

    List<E> asList();

    Iterator<E> iterator();

    List<E> getValue();

}


