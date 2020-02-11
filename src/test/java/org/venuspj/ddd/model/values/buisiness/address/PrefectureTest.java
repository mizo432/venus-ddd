package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class PrefectureTest {

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty1() {
        assertThat(Prefecture.empty().isEmpty())
                .isTrue();


    }

}
