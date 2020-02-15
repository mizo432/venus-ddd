package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;

public class MomentTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of1() {
        Moment<LocalDateTime> target = Moment.of(LocalDateTime.now());
        LocalDateTime actual = target.getValue();
        System.out.println(actual);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of2() {
        Moment<LocalDate> target = Moment.of(LocalDate.now());
        LocalDate actual = target.getValue();
        System.out.println(actual);

    }


    @Test
    @Tag(TestSize.SMALL)
    public void of3() {
        Moment<YearMonth> target = Moment.of(YearMonth.now());
        YearMonth actual = target.getValue();
        System.out.println(actual);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of4() {
        Moment<Year> target = Moment.of(Year.now());
        Year actual = target.getValue();
        System.out.println(actual);

    }
}
