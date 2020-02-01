package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractSingleValue;
import org.venuspj.util.exception.NotSupportedMethod;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import static org.venuspj.util.collect.Sets2.newHashSet;

public class AbstractSetValue<E, AMV extends AbstractSetValue<E, AMV>> extends AbstractSingleValue<Set<E>, AMV> implements SetValue<E, AMV> {

    protected AbstractSetValue() {
        this.value = newHashSet();
    }

    protected AbstractSetValue(Collection<E> aCollection) {
        this();
        super.value.addAll(aCollection);

    }

    @Override
    public int compareTo(AMV o) {
        throw new NotSupportedMethod(this.getClass().getCanonicalName() + "#compareTo(" + o.getClass().getSimpleName() + ")");
    }

    @Override
    public Set<E> asSet() {
        return value;

    }

    @Override
    public Iterator<E> iterator() {
        return value.iterator();
    }
}
