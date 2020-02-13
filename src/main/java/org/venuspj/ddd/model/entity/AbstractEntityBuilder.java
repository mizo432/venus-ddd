package org.venuspj.ddd.model.entity;

import org.venuspj.util.builder.ObjectBuilder;

import static org.venuspj.util.objects2.Objects2.isNull;

public abstract class AbstractEntityBuilder<
        E extends AbstractEntity<E, EI>,
        EI extends EntityIdentifier<EI>,
        B extends AbstractEntityBuilder<E, EI, B>> extends ObjectBuilder<E, B> {

    protected EI identifier;

    protected void apply(E vo, B builder) {
        builder.withIdentifier(vo.getIdentifier());

    }


    public B withIdentifier(EI anIdentifier) {
        if (isNull(anIdentifier))
            return getThis();
        addConfigurator(builder -> builder.identifier = anIdentifier);
        return getThis();

    }

}
