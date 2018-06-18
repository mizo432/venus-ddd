package org.venuspj.ddd.model.value;

import java.util.Iterator;
import java.util.List;

public interface ListValue<E> extends Iterable<E> {

    List<E> asList();

    Iterator<E> iterator();

    List<E> getValue();

}


