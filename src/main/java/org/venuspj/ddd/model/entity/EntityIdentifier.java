package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.value.Value;

public interface EntityIdentifier<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI, T>, T> extends Value<EI> {

    T getValue();

    String getKind();

}
