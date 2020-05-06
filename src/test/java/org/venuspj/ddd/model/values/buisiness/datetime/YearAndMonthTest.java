package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;

public class YearAndMonthTest {

    @Test
    @Tag("small")
    public void of() {
        YearAndMonth target = YearAndMonth.of(YearMonth.of(2020, 1));
        System.out.println(target.toString());
        assertThat(target.asText())
                .isEqualTo("2020-01");
    }

    @Test
    @Tag("small")
    public void constructor() {
        YearAndMonth target = new YearAndMonth("2020-01");
        System.out.println(target.toString());
        assertThat(target.asText())
                .isEqualTo("2020-01");
    }

}
