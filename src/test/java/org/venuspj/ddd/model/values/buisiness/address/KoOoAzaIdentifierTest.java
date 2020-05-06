package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KoOoAzaIdentifierTest {
    @Test
    @Tag("small")
    public void empty() {
        AzaIdentifier target = AzaIdentifier.empty();

        assertThat(target.sameValueAs(target))
                .isTrue();

    }

    @Test
    @Tag("small")
    public void of() {
        AzaIdentifier target = AzaIdentifier.of(10L);

        assertThat(target.sameValueAs(target))
                .isTrue();

    }
}
