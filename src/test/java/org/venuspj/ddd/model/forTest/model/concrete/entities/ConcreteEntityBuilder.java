package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.entity.AbstractEntityBuilder;

public class ConcreteEntityBuilder extends AbstractEntityBuilder<ConcreteEntity, ConcreteEntityIdentifier, ConcreteInfo
        , ConcreteEntityBuilder> {

    @Override
    protected void apply(ConcreteEntity vo, ConcreteEntityBuilder builder) {
        builder.withIdentifier(vo.getIdentifier());

    }

    public ConcreteEntityBuilder withConcreteInfo(ConcreteInfo aConcreteInfo) {
        return withEntityInfo(aConcreteInfo);

    }

    @Override
    protected ConcreteEntity createValueObject() {
        return new ConcreteEntity(identifier, entityInfo);
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
