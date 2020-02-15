package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import java.time.*;

public class IntervalTest {

    @Test
    @Tag(TestSize.SMALL)
    public void createFrom1() {
        Interval<LocalDateTime> target = Interval
                .createFrom(
                        Moment
                                .of(LocalDateTime.of(2020, 1, 1, 0, 0, 0, 0)),
                        Moment
                                .of(LocalDateTime.MAX));
        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void createFrom2() {
        Interval<LocalDate> target = Interval
                .createFrom(
                        Moment
                                .of(LocalDate.of(2020, 1, 1)),
                        Moment
                                .of(LocalDate.MAX));
        System.out.println(target.toString());

    }


    @Test
    @Tag(TestSize.SMALL)
    public void createFrom3() {
        Interval<YearMonth> target = Interval
                .createFrom(
                        Moment
                                .of(YearMonth.of(2020, 1)),
                        Moment
                                .of(YearMonth.of(Year.MAX_VALUE, Month.DECEMBER)));
        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void createFrom4() {
        Interval<Year> target = Interval
                .createFrom(
                        Moment
                                .of(Year.of(2020)),
                        Moment
                                .of(Year.of(Year.MAX_VALUE)));
        System.out.println(target.toString());

    }

}
