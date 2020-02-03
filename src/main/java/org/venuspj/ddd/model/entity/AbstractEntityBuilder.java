package org.venuspj.ddd.model.entity;

import org.venuspj.util.builder.ObjectBuilder;

import static org.venuspj.util.objects2.Objects2.isNull;

public abstract class AbstractEntityBuilder<T extends AbstractEntity<T, EI>, EI extends AbstractEntityIdentifier<T, EI>, B extends AbstractEntityBuilder<T, EI, B>> extends ObjectBuilder<T, B> {
    protected EI identifier;

    public B withIdentifier(EI anIdentifier) {
        if (isNull(anIdentifier))
            return getThis();
        addConfigurator(builder -> builder.identifier = anIdentifier);
        return getThis();

    }

}
