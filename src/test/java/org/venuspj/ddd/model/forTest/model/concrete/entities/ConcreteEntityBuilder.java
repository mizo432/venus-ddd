package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.entity.AbstractEntityBuilder;

public class ConcreteEntityBuilder extends AbstractEntityBuilder<ConcreteEntity, ConcreteEntityIdentifier, ConcreteInfo
        , ConcreteEntityBuilder> {
    ConcreteEntityBuilder() {
        identifier = ConcreteEntityIdentifier.empty();
        entityInfo = ConcreteInfo.empty();

    }

    @Override
    protected void apply(ConcreteEntity vo, ConcreteEntityBuilder builder) {
        builder.withIdentifier(vo.getIdentifier());
        builder.withConcreteInfo(vo.getConcreteInfo());

    }

    public ConcreteEntityBuilder withConcreteInfo(ConcreteInfo aConcreteInfo) {
        return withEntityInfo(aConcreteInfo);

    }

    @Override
    protected ConcreteEntity createValueObject() {
        return new ConcreteEntity(super.identifier, super.entityInfo);

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
