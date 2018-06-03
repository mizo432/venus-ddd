package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.Entity;
import org.venuspj.ddd.model.entity.EntityIdentifier;

/**
 * 指定された識別子を持つエンティティが見つからなかった場合にスローされる例外
 */
public class EntityNotFoundRuntimeException extends RuntimeException {
    EntityIdentifier<?> identifier;

    public <T extends Entity<T>> EntityNotFoundRuntimeException(EntityIdentifier<?> anIdentifier) {
        super("Entity not found. getIdentifier:" + anIdentifier);
        identifier = anIdentifier;

    }

    public <T extends Entity<T>> EntityNotFoundRuntimeException(EntityCriteria<T> criteria) {
    }

    EntityIdentifier<?> identifier() {
        return identifier;
    }
}
