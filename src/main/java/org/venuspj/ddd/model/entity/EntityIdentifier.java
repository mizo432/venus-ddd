package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.values.Value;

/**
 * エンティティ識別
 *
 * @param <EI> エンティティ識別子
 */
public interface EntityIdentifier<EI extends EntityIdentifier<EI>> extends Value<EI> {

    String getKind();

    boolean isEmpty();
}
