package org.venuspj.ddd.model.entity;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntity;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityBuilder;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityIdentifier;
import org.venuspj.tests.constants.TestSize;

public class AbstractEntityBuilderTest {

    @Test
    @Tag(TestSize.SMALL)
    public void build() {
        ConcreteEntity actual = new ConcreteEntityBuilder()
                .withIdentifier(ConcreteEntityIdentifier.of(10L))
                .build();

        System.out.println(actual);

    }

}
