package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.name.Name;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class AzaTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        Aza target = Aza.empty();
        assertThat(target.isEmpty())
                .isTrue();

        System.out.println(true);
    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        Aza target = Aza.of(AzaIdentifier.of(1L),
                AzaCode.of("001"),
                Name.of("１丁目"),
                Name.of("１ッチョウメ"));
        assertThat(target.isEmpty())
                .isFalse();

        System.out.println(true);
    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs1() {
        Aza target = AzaMock.one();
        assertThat(target.sameValueAs(AzaMock.one()))
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs2() {
        Aza target = AzaMock.one();
        assertThat(target.sameValueAs(target))
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs3() {
        Aza target = AzaMock.one();
        assertThat(target.sameValueAs(null))
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs4() {
        Aza target = AzaMock.one();
        assertThat(target.sameValueAs(AzaMock.two()))
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameIdentifierAs1() {
        Aza target = AzaMock.one();
        assertThat(target.sameIdentifierAs(AzaMock.one()))
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameIdentifierAs2() {
        Aza target = AzaMock.one();
        assertThat(target.sameIdentifierAs(target))
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameIdentifierAs3() {
        Aza target = AzaMock.one();
        assertThat(target.sameIdentifierAs(null))
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameIdentifierAs4() {
        Aza target = AzaMock.one();
        assertThat(target.sameIdentifierAs(AzaMock.two()))
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameIdentifierAs5() {
        Aza target = AzaMock.one();
        assertThat(target.sameIdentifierAs(AzaMock.sameIdentifier()))
                .isTrue();

    }

    public static class AzaMock {
        Aza empty() {
            return Aza.empty();
        }

        static Aza one() {
            return Aza
                    .builder()
                    .withIdentifier(AzaIdentifier.of(1L))
                    .withAzaCode(AzaCode.of("001"))
                    .withName(Name.of("１丁目"))
                    .withKanaName(Name.of("１ッチョウメ"))
                    .build();
        }

        static Aza two() {
            return Aza
                    .builder()
                    .withIdentifier(AzaIdentifier.of(2L))
                    .withAzaCode(AzaCode.of("001"))
                    .withName(Name.of("１丁目"))
                    .withKanaName(Name.of("１ッチョウメ"))
                    .build();
        }

        static Aza sameIdentifier() {
            return Aza
                    .builder()
                    .withIdentifier(AzaIdentifier.of(1L))
                    .withAzaCode(AzaCode.of("001-1"))
                    .withName(Name.of("１丁目-1"))
                    .withKanaName(Name.of("１ッチョウメ-1"))
                    .build();
        }
    }
}
