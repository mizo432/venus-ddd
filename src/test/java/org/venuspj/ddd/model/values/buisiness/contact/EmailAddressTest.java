package org.venuspj.ddd.model.values.buisiness.contact;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailAddressTest {

    @Test
    @Tag("small")
    public void of() {
        EmailAddress target = EmailAddress.of("testData");
        assertThat(target)
                .isNotNull();
        assertThat(target.isPresent())
                .isTrue();

    }

    @Test
    @Tag("small")
    public void empty() {
        EmailAddress target = EmailAddress.empty();
        assertThat(target)
                .isNotNull();
        assertThat(target.isEmpty())
                .isTrue();
    }

}
