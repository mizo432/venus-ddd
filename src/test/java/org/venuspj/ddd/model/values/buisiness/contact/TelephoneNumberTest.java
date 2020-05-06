package org.venuspj.ddd.model.values.buisiness.contact;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TelephoneNumberTest {

    @Test
    @Tag("small")
    public void of() {
        TelephoneNumber target = TelephoneNumber.of("testData");
        assertThat(target)
                .isNotNull();
        assertThat(target.isPresent())
                .isTrue();

    }

    @Test
    @Tag("small")
    public void empty() {
        TelephoneNumber target = TelephoneNumber.empty();
        assertThat(target)
                .isNotNull();
        assertThat(target.isEmpty())
                .isTrue();
    }

}
