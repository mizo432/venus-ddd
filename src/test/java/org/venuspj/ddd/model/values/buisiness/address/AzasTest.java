package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class AzasTest {

    @Test
    @Tag("small")
    public void empty() {
        Azas target = Azas.empty();
        assertThat(target.asList())
                .isNotNull();

        System.out.println(true);
    }

    @Test
    @Tag("small")
    public void of() {
        Azas target = Azas.of(newArrayList());
        assertThat(target.asList())
                .isNotNull();

        System.out.println(true);
    }
}
