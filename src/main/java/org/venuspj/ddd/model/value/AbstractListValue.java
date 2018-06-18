package org.venuspj.ddd.model.value;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.venuspj.util.collect.Lists2.newArrayList;
import static org.venuspj.util.collect.Lists2.unmodifiableList;

public abstract class AbstractListValue<E> implements ListValue<E> {
    protected List<E> list = newArrayList();

    protected AbstractListValue() {
    }

    protected AbstractListValue(Collection<? extends E> anyCollection) {
        list.addAll(anyCollection);

    }

    @Override
    public List<E> asList() {
        return unmodifiableList(list);

    }

    public Iterator<E> iterator() {
        return list.iterator();
    }

    @Override
    public List<E> getValue() {
        return list;
    }
}
