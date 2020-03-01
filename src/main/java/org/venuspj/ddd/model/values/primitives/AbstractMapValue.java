package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractSingleValue;
import org.venuspj.util.exception.NotSupportedMethod;

import java.util.Map;

public class AbstractMapValue<K, E, AMV extends AbstractMapValue<K, E, AMV>> extends AbstractSingleValue<Map<K, E>, AMV> implements MapValue<K, E, AMV> {

    protected AbstractMapValue() {

    }

    protected AbstractMapValue(Map<K, E> aMap) {
        super(aMap);

    }

    @Override
    public int compareTo(AMV o) {
        throw new NotSupportedMethod(this.getClass().getCanonicalName() + "#compareTo(" + o.getClass().getSimpleName() + ")");

    }

    @Override
    public Map<K, E> asMap() {
        return value;
    }
}
