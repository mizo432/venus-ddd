package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.util.builder.ObjectBuilder;

import static org.venuspj.util.objects2.Objects2.isNull;

public abstract class AbstractEntityBuilder<T extends AbstractEntity<T, EI, V>, EI extends AbstractEntityIdentifier<T, EI>, V extends Value<V>, B extends AbstractEntityBuilder<T, EI, V, B>> extends ObjectBuilder<T, B> {
    protected EI identifier;
    protected V entityInfo;

    public B withIdentifier(EI anIdentifier) {
        if (isNull(anIdentifier))
            return getThis();
        addConfigurator(builder -> builder.identifier = anIdentifier);
        return getThis();

    }

    protected B withEntityInfo(V anEntityInfo) {
        if (isNull(anEntityInfo))
            return getThis();
        addConfigurator(builder -> builder.entityInfo = anEntityInfo);
        return getThis();

    }


}
