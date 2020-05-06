package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class CitiesTest {

    @Test
    @Tag("small")
    public void empty() {
        Cities target = Cities.empty();
        assertThat(target.asList())
                .isNotNull();

        System.out.println(true);
    }

    @Test
    @Tag("small")
    public void of() {
        Cities target = Cities.of(newArrayList());
        assertThat(target.asList())
                .isNotNull();

        System.out.println(true);
    }
}
