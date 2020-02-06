package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class PrefectureTest {

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty1() {
        assertThat(Prefecture.EMPTY.isEmpty())
                .isTrue();


    }

    @Test
    @Tag(TestSize.SMALL)
    public void isEmpty2() {
        assertThat(Prefecture.北海道.isEmpty())
                .isFalse();


    }
}
