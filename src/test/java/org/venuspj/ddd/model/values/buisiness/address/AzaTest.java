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
}
