package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractSingleValue;
import org.venuspj.util.exception.NotSupportedMethod;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.venuspj.util.collect.Lists2.newArrayList;
import static org.venuspj.util.collect.Lists2.unmodifiableList;
import static org.venuspj.util.objects2.Objects2.equal;

public abstract class AbstractListValue<E, ALV extends AbstractListValue<E, ALV>> extends AbstractSingleValue<List<E>, ALV> implements ListValue<E, ALV> {

    protected AbstractListValue() {
        value = newArrayList();
    }

    protected AbstractListValue(Collection<? extends E> anyCollection) {
        this();
        value.addAll(anyCollection);

    }

    @Override
    public List<E> asList() {
        return unmodifiableList(value);

    }

    public Iterator<E> iterator() {
        return value.iterator();
    }

    @Override
    public List<E> getValue() {
        return value;
    }

    @Override
    public int compareTo(ALV o) {
        throw new NotSupportedMethod(this.getClass().getCanonicalName() + "#compareTo(" + o.getClass().getSimpleName() + ")");
    }

    @Override
    public boolean sameValueAs(ALV that) {
        if (size() != that.size())
            return false;
        for (int index = 0; index < value.size(); index++) {
            if (!equal(value.get(index), that.value.get(index)))
                return false;
        }
        return true;
    }

    protected int size() {
        return value.size();
    }

}
