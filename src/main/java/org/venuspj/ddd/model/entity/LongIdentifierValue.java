package org.venuspj.ddd.model.entity;


import org.venuspj.ddd.model.value.LongValue;

/**
 * Created by mizoguchi on 2017/07/01.
 * Longを保持するIdentifierのインタフェイス
 */
public interface LongIdentifierValue<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI, Long>>
        extends EntityIdentifier<E, EI, Long> {

}
