package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.name.Name;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class CityTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        City target = City.empty();
        assertThat(target.isEmpty())
                .isTrue();

        System.out.println(true);
    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        City target = City.of(CityIdentifier.of(10L), CityCode.of("001"), Name.of("前橋市"), Name.of("まえばしし"));
        assertThat(target.isEmpty())
                .isFalse();

        System.out.println(target);
    }

}
