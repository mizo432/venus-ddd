package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.entity.AbstractEntityBuilder;

import static org.venuspj.util.objects2.Objects2.isNull;

public class ConcreteEntityBuilder extends AbstractEntityBuilder<ConcreteEntity, ConcreteEntityIdentifier
        , ConcreteEntityBuilder> {
    ConcreteInfo concreteInfo;

    ConcreteEntityBuilder() {
        identifier = ConcreteEntityIdentifier.empty();

    }

    @Override
    protected void apply(ConcreteEntity vo, ConcreteEntityBuilder builder) {
        builder.withIdentifier(vo.getIdentifier());
        builder.withConcreteInfo(vo.concreteInfo());

    }

    public ConcreteEntityBuilder withConcreteInfo(ConcreteInfo aConcreteInfo) {
        if (isNull(aConcreteInfo)) return getThis();
        addConfigurator(builder -> builder.concreteInfo = aConcreteInfo);
        return getThis();

    }

    @Override
    protected ConcreteEntity createValueObject() {
        return new ConcreteEntity(super.identifier, concreteInfo);

    }

    @Override
    protected ConcreteEntityBuilder getThis() {
        return this;

    }

    @Override
    protected ConcreteEntityBuilder newInstance() {
        return new ConcreteEntityBuilder();

    }
}
