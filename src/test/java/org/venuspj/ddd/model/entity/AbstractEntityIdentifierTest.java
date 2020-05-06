package org.venuspj.ddd.model.entity;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntity;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityIdentifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class AbstractEntityIdentifierTest {

    @Test
    @Tag("small")
    public void of01() {
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.of(1L);
        System.out.println(toStringHelper(target).defaultConfig().toString());
    }

    @Test
    @Tag("small")
    public void empty01() {
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.empty();
        System.out.println(toStringHelper(target).defaultConfig().toString());
        assertThat(target.isEmpty())
                .isTrue();
    }

    @Test
    @Tag("small")
    public void sameValueOf01() {
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.empty();

        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();
    }

    @Test
    @Tag("small")
    public void hashCode01() {
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.empty();

        int actual = target.hashCode();

        assertThat(actual)
                .isEqualTo(-38784083);
    }

    @Test
    @Tag("small")
    public void getKind1() {
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.empty();
        String actual = target.getKind();


        assertThat(actual)
                .isEqualTo(ConcreteEntity.class.getCanonicalName());
    }

    @Test
    @Tag("small")
    public void equals1() {
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.empty();
        boolean actual = target.equals(target);


        assertThat(actual)
                .isTrue();
    }

    @Test
    @Tag("small")
    public void equals2() {
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.empty();
        boolean actual = target.equals(null);


        assertThat(actual)
                .isFalse();
    }

    @Test
    @Tag("small")
    public void equals3() {
        ConcreteEntityIdentifier arg = ConcreteEntityIdentifier.empty();
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.empty();
        boolean actual = target.equals(arg);


        assertThat(actual)
                .isTrue();
    }

    @Test
    @Tag("small")
    public void equals4() {
        ConcreteEntityIdentifier arg = ConcreteEntityIdentifier.of(1L);
        ConcreteEntityIdentifier target = ConcreteEntityIdentifier.of(2L);
        boolean actual = target.equals(arg);


        assertThat(actual)
                .isFalse();
    }

}
