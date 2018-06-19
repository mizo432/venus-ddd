package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.value.IntegerValue;

/**
 * @param <E>
 * @param <EI>
 */
public interface IntegerIdentifierValue<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI, Integer>>
        extends EntityIdentifier<E, EI, Integer> {

}

