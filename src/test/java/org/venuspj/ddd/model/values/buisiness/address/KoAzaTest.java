package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class KoAzaTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        KoAza target = KoAza.of(KoAzaIdentifier.empty(), KoAzaInformation.empty());
        assertThat(target)
                .isNotNull();

        System.out.println(true);
    }
}
