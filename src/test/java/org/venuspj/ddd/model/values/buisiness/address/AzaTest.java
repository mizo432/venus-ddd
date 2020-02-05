package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class AzaTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        Aza target = Aza.empty();
        assertThat(target)
                .isNotNull();

        System.out.println(true);
    }

    @Test
    @Tag(TestSize.SMALL)
    public void getAzaInformation() {
        Aza target = Aza.of(AzaIdentifier.empty(), AzaInformation.empty());
        assertThat(target.getAzaInformation())
                .isNotNull();

        System.out.println(true);
    }

}
