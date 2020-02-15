package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.Temporal;

public class MomentTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of2() {
        Moment target = Moment.of(LocalDateTime.now());
        Temporal actual = target.getValue();
        System.out.println(actual);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of1() {
        Moment target = Moment.of(LocalDate.now());
        Temporal actual = target.getValue();
        System.out.println(actual);

    }


    @Test
    @Tag(TestSize.SMALL)
    public void of3() {
        Moment target = Moment.of(YearMonth.now());
        Temporal actual = target.getValue();
        System.out.println(actual);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of4() {
        Moment target = Moment.of(Year.now());
        Temporal actual = target.getValue();
        System.out.println(actual);

    }
}
