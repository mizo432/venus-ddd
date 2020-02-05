package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class AzasTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of1() {
        Collection<Aza> list = AzasMock.empty();
        Azas actual = Azas.of(list);
        assertThat(actual.asList())
                .isEmpty();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of2() {
        Collection<Aza> list = AzasMock.twoAza();
        Azas actual = Azas.of(list);
        assertThat(actual.asList())
                .hasSize(2);

    }

    private static class AzasMock {
        public static List<Aza> empty() {
            return newArrayList();
        }

        public static List<Aza> twoAza() {
            return newArrayList(AzaTest.AzaMock.one(), AzaTest.AzaMock
                    .one());
        }
    }
}
