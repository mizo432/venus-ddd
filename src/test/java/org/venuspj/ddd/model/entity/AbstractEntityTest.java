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

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs1() {

        ConcreteEntity target = ConcreteEntity.empty();
        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs2() {
        ConcreteEntity arg = ConcreteEntity.empty();

        ConcreteEntity target = ConcreteEntity.empty();
        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs3() {
        ConcreteEntity arg = ConcreteEntity.of(ConcreteEntityIdentifier.of(10L));

        ConcreteEntity target = ConcreteEntity.of(ConcreteEntityIdentifier.of(10L));
        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs4() {
        ConcreteEntity arg = ConcreteEntity.of(ConcreteEntityIdentifier.of(11L));

        ConcreteEntity target = ConcreteEntity.of(ConcreteEntityIdentifier.of(10L));
        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isFalse();

    }

}
