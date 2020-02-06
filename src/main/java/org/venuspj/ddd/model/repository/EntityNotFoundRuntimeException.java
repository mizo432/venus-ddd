package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.Entity;
import org.venuspj.ddd.model.entity.EntityIdentifier;

import static org.venuspj.util.objects2.Objects2.toStringHelper;

/**
 * 指定された識別子を持つエンティティが見つからなかった場合にスローされる例外
 */
public class EntityNotFoundRuntimeException extends Exception {
    EntityIdentifier<?, ?> identifier;

    public <T extends Entity<T, ?>> EntityNotFoundRuntimeException(EntityIdentifier<?, ?> identifier) {
        super(createMessage(identifier));
        this.identifier = identifier;

    }

    public EntityNotFoundRuntimeException(Throwable t) {
        super("Entity not found.", t);
    }

    private static String createMessage(EntityIdentifier<?, ?> identifier) {
        return "Entity not found. getIdentifier: " + toStringHelper(identifier).defaultConfig().toString();
    }

    public <T extends Entity<T, ?>> EntityNotFoundRuntimeException(EntityCriteria<T> criteria) {

    }

    public EntityNotFoundRuntimeException() {
        super("Entity not found.");

    }

    public <T extends Entity<T, ?>> EntityNotFoundRuntimeException(EntityIdentifier<?, ?> identifier, Throwable t) {
        super(createMessage(identifier), t);
        this.identifier = identifier;

    }

    EntityIdentifier<?, ?> identifier() {
        return identifier;
    }
}
