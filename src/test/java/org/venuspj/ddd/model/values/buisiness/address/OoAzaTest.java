package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.name.Name;

import static org.assertj.core.api.Assertions.assertThat;

public class OoAzaTest {
    @Test
    @Tag("small")
    public void empty() {
        OoAza target = OoAza.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void of() {
        OoAza target = OoAza.of(OoAzaIdentifier.of(1L), OoAzaCode.of("001"), Name.of("千代田"), Name.of("チヨダ"));

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    public void sameValueAs1() {
        OoAza target = OoAza.empty();

        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void sameValueAs2() {
        OoAza target = OoAza.empty();

        boolean actual = target.sameValueAs(null);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    public void sameValueAs3() {
        OoAza arg = OoAza.empty();
        OoAza target = OoAza.empty();

        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void toString1() {
        OoAza target = OoAza.empty();

        System.out.println(target.toString());

    }

    @Test
    @Tag("small")
    public void equals1() {
        SimpleAddress arg = SimpleAddress.empty();
        OoAza target = OoAza.empty();
        boolean actual = target.equals(arg);
        assertThat(actual)
                .isFalse();

        System.out.println(target.toString());

    }

}
