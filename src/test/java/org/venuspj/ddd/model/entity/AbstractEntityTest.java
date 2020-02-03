package org.venuspj.ddd.model.entity;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntity;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityIdentifier;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractEntityTest {

    @Test
    @Tag(TestSize.SMALL)
    public void hash() {
        ConcreteEntity target = new ConcreteEntity();
        int actual = target.hashCode();

        assertThat(actual)
                .isEqualTo(new ConcreteEntityIdentifier().hashCode());

    }

}
