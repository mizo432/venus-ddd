package org.venuspj.ddd.model.entity;

import org.venuspj.util.builder.ObjectBuilder;

import static java.util.Objects.isNull;

/**
 *
 */
public abstract class EntityBuilder<E extends Entity<E, ?>, B extends EntityBuilder<E, B>> extends ObjectBuilder<E, B> {

    protected EntityIdentifier<E, ?> identifier;

    @Override
    protected void apply(E vo, B builder) {
        builder.withEntityIdentifier(vo.getIdentifier());
    }

    public B withEntityIdentifier(EntityIdentifier<E, ?> identifier) {
        if (isNull(identifier)) return getThis();
        addConfigurator(builder -> builder.identifier = identifier);
        return getThis();

    }
}
