package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class OoAzasTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty1() {
        OoAzas actual = OoAzas.empty();
        assertThat(actual.asList())
                .isEmpty();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of1() {
        Collection<OoAza> list = AzasMock.empty();
        OoAzas actual = OoAzas.of(list);
        assertThat(actual.asList())
                .isEmpty();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of2() {
        Collection<OoAza> list = AzasMock.twoAza();
        OoAzas actual = OoAzas.of(list);
        assertThat(actual.asList())
                .hasSize(2);

    }

    private static class AzasMock {
        public static List<OoAza> empty() {
            return newArrayList();
        }

        public static List<OoAza> twoAza() {
            return newArrayList(OoAzaTest.AzaMock.one(), OoAzaTest.AzaMock
                    .one());
        }
    }
}
