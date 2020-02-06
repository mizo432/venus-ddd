package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.entity.AbstractEntity;

import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class ConcreteEntity extends AbstractEntity<ConcreteEntity, ConcreteEntityIdentifier, ConcreteInfo> {

    public ConcreteEntity() {
        super(ConcreteEntityIdentifier.empty(), ConcreteInfo.empty());

    }

    public ConcreteEntity(ConcreteEntityIdentifier aConcreteEntityIdentifier, ConcreteInfo aConcreteInfo) {
        super(aConcreteEntityIdentifier, aConcreteInfo);

    }

    public static ConcreteEntity empty() {
        return new ConcreteEntity();
    }

    public static ConcreteEntity of(ConcreteEntityIdentifier aConcreteEntityIdentifier, ConcreteInfo aConcreteInfo) {
        return new ConcreteEntity(aConcreteEntityIdentifier, aConcreteInfo);
    }

    public static ConcreteEntityBuilder builder() {
        return new ConcreteEntityBuilder();

    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();

    }
}
