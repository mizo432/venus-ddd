package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.Value;

import java.util.Map;

public interface MapValue<K, E, MV extends MapValue<K, E, MV>> extends Value<MV> {

    Map<K, E> asMap();


    Map<K, E> getValue();

}


