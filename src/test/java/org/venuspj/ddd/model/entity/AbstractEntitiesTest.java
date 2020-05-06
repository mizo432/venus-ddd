package org.venuspj.ddd.model.entity;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntities;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntity;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityIdentifier;
import org.venuspj.ddd.model.repository.EntityNotFoundRuntimeException;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class AbstractEntitiesTest {

    @Test
    @Tag("small")
    public void empty() {
        ConcreteEntities actual = ConcreteEntities.empty();
        assertThat(actual.asList())
                .isEmpty();


    }

    @Test
    @Tag("small")
    public void of1() {
        ConcreteEntities actual = ConcreteEntities.of(ConcreteEntitiesMock.empty());
        assertThat(actual.asList())
                .isEmpty();


    }

    @Test
    @Tag("small")
    public void of2() {
        ConcreteEntities actual = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        assertThat(actual.asList())
                .hasSize(2);


    }

    @Test
    @Tag("small")
    public void getValue() {
        ConcreteEntities actual = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        assertThat(actual.getValue())
                .hasSize(2);


    }

    @Test
    @Tag("small")
    public void sameValueAs1() {
        ConcreteEntities target = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        final boolean actual = target.sameValueAs(target);
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void sameValueAs2() {
        ConcreteEntities arg = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        ConcreteEntities target = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        final boolean actual = target.sameValueAs(arg);
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void sameValueAs3() {
        ConcreteEntities arg = ConcreteEntities.of(ConcreteEntitiesMock.threeEntities());
        ConcreteEntities target = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        final boolean actual = target.sameValueAs(arg);
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    public void sameValueAs4() {
        ConcreteEntities arg = ConcreteEntities.of(ConcreteEntitiesMock.otherTwoEntities());
        ConcreteEntities target = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        final boolean actual = target.sameValueAs(arg);
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    public void sameValueAs5() {
        ConcreteEntities target = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        final boolean actual = target.sameValueAs(null);
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    public void findEntityBy1() throws EntityNotFoundRuntimeException {
        ConcreteEntities target = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        ConcreteEntity actual = target.findEntityBy(ConcreteEntityIdentifier.of(1L));
        assertThat(actual)
                .isNotNull();

    }

    @Test
    @Tag("small")
    public void findEntityBy2() {
        ConcreteEntities target = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        try {
            target.findEntityBy(ConcreteEntityIdentifier.of(3L));
            fail("例外が出るはずが正常に終わってしまった");
        } catch (EntityNotFoundRuntimeException e) {
        }

    }

    @Test
    @Tag("small")
    public void selectEntityBy1() {
        ConcreteEntities target = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        ConcreteEntities actual = target.selectEntityBy(entity -> entity.getIdentifier().equals(ConcreteEntityIdentifier.of(2L)));
        assertThat(actual.asList())
                .hasSize(1);

    }

    @Test
    @Tag("small")
    public void selectEntityBy2() {
        ConcreteEntities target = ConcreteEntities.of(ConcreteEntitiesMock.twoEntities());
        ConcreteEntities actual = target.selectEntityBy(entity -> entity.getIdentifier().equals(ConcreteEntityIdentifier.of(3L)));
        assertThat(actual.asList())
                .isEmpty();

    }

    private static class ConcreteEntitiesMock {
        public static Collection<ConcreteEntity> empty() {
            return newArrayList();

        }

        public static Collection<ConcreteEntity> twoEntities() {
            return newArrayList(AbstractEntityTest.ConcreteEntityMock.one(), AbstractEntityTest.ConcreteEntityMock.two());
        }

        public static Collection<ConcreteEntity> threeEntities() {
            return newArrayList(AbstractEntityTest.ConcreteEntityMock.one(), AbstractEntityTest.ConcreteEntityMock.two(), AbstractEntityTest.ConcreteEntityMock.three());
        }

        public static Collection<ConcreteEntity> otherTwoEntities() {
            return newArrayList(AbstractEntityTest.ConcreteEntityMock.one(), AbstractEntityTest.ConcreteEntityMock.three());
        }
    }

}
