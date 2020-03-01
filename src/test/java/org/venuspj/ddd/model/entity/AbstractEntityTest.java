package org.venuspj.ddd.model.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.json.JsonMapperEx;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntity;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityIdentifier;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteInfo;
import org.venuspj.ddd.model.values.buisiness.name.Name;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class AbstractEntityTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        ConcreteEntity target = ConcreteEntity.empty();
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty1() {
        ConcreteEntity target = new ConcreteEntity();
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty3() {
        ConcreteEntity target = ConcreteEntity.of(ConcreteEntityIdentifier.of(1L), ConcreteInfo.of(Name.of("ABC")));
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty4() {
        ConcreteEntity target = ConcreteEntity.of(ConcreteEntityIdentifier.of(1L), ConcreteInfo.empty());
        boolean actual = target.isEmpty();

        assertThat(actual)
                .isFalse();

    }

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
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs2() {
        ConcreteEntity arg = ConcreteEntity.empty();

        ConcreteEntity target = ConcreteEntity.empty();
        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs3() {
        ConcreteEntity arg = ConcreteEntity.of(ConcreteEntityIdentifier.of(10L), ConcreteInfo.empty());

        ConcreteEntity target = ConcreteEntity.of(ConcreteEntityIdentifier.of(10L), ConcreteInfo.empty());
        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs4() {
        ConcreteEntity arg = ConcreteEntity.of(ConcreteEntityIdentifier.of(11L), ConcreteInfo.empty());

        ConcreteEntity target = ConcreteEntity.of(ConcreteEntityIdentifier.of(10L), ConcreteInfo.empty());
        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isFalse();

    }

    public static class ConcreteEntityMock {
        public static ConcreteEntity empty() {
            return ConcreteEntity.empty();

        }

        public static ConcreteEntity one() {
            return ConcreteEntity.of(ConcreteEntityIdentifier.of(1L), ConcreteInfo.empty());
        }

        public static ConcreteEntity two() {
            return ConcreteEntity.of(ConcreteEntityIdentifier.of(2L), ConcreteInfo.empty());
        }

        public static ConcreteEntity three() {
            return ConcreteEntity.of(ConcreteEntityIdentifier.of(3L), ConcreteInfo.empty());
        }
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson1() throws JsonProcessingException {
        ConcreteEntity target = ConcreteEntityMock.one();
        JsonMapperEx objectMapper = new JsonMapperEx();

        String json = objectMapper.writeValueAsString(target);

        ConcreteEntity actual = objectMapper.readValue(json, ConcreteEntity.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson2() throws JsonProcessingException {
        ConcreteEntity target = ConcreteEntity.empty();
        JsonMapperEx objectMapper = new JsonMapperEx();

        String json = objectMapper.writeValueAsString(target);

        ConcreteEntity actual = objectMapper.readValue(json, ConcreteEntity.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

}
