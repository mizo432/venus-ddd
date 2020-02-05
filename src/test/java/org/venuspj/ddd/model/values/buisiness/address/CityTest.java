package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class CityTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        City target = City.of(CityIdentifier.empty(), CityInformation.empty());
        assertThat(target)
                .isNotNull();

        System.out.println(true);
    }
}
