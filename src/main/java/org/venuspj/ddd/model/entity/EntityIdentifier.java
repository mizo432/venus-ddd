package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.values.primitives.LongSingleValue;

/**
 * エンティティ識別
 *
 * @param <E>  エンティティ
 * @param <EI> エンティティ識別子
 */
public interface EntityIdentifier<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI>> extends LongSingleValue<EI> {

    String getKind();

    boolean isEmpty();
}
