package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OoAzaIdentifierTest {

    @Test
    @Tag("small")
    public void empty() {
        OoAzaIdentifier target = OoAzaIdentifier.empty();

        assertThat(target.sameValueAs(target))
                .isTrue();

    }

    @Test
    @Tag("small")
    public void of() {
        OoAzaIdentifier target = OoAzaIdentifier.of(10L);

        assertThat(target.sameValueAs(target))
                .isTrue();

    }

}
