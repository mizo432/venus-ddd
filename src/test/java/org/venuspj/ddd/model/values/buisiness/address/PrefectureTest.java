package org.venuspj.ddd.model.values.buisiness.address;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.name.Name;

import static org.assertj.core.api.Assertions.assertThat;

public class PrefectureTest {

    @Test
    @Tag("small")
    public void isEmpty1() {
        assertThat(Prefecture.empty().isEmpty())
                .isTrue();


    }

    @Test
    @Tag("small")
    public void builder1() {
        Prefecture actual = Prefecture.builder()
                .withIdentifier(PrefectureIdentifier.of(1L))
                .withPrefectureCode(PrefectureCode.of("10"))
                .withKanaName(Name.of("ほっかいどう"))
                .withName(Name.of("北海道"))
                .build();
        System.out.println(actual.toString());

        assertThat(actual.isEmpty())
                .isFalse();


    }


}
