package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.*;

import static org.assertj.core.api.Assertions.assertThat;

public class IntervalTest {

    @Test
    @Tag("small")
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
    @Tag("small")
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
    @Tag("small")
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
    @Tag("small")
    public void createFrom4() {
        Interval<Year> target = Interval
                .createFrom(
                        Moment
                                .of(Year.of(2020)),
                        Moment
                                .of(Year.of(Year.MAX_VALUE)));
        System.out.println(target.toString());

    }

    @Test
    @Tag("small")
    public void isOverlap1() {
        Interval<Year> arg = Interval.createFrom(Moment.of(Year.of(2020)), Moment.of(Year.of(2022)));

        Interval<Year> target = Interval.createFrom(Moment.of(Year.of(2020)), Moment.of(Year.of(2022)));

        boolean actual = target.isOverlap(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void isOverlap2() {
        Interval<Year> arg = Interval.createFrom(Moment.of(Year.of(2020)), Moment.of(Year.of(2021)));

        Interval<Year> target = Interval.createFrom(Moment.of(Year.of(2020)), Moment.of(Year.of(2022)));

        boolean actual = target.isOverlap(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void isOverlap3() {
        Interval<Year> arg = Interval.createFrom(Moment.of(Year.of(2021)), Moment.of(Year.of(2022)));

        Interval<Year> target = Interval.createFrom(Moment.of(Year.of(2020)), Moment.of(Year.of(2022)));

        boolean actual = target.isOverlap(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void isOverlap4() {
        Interval<Year> arg = Interval.createFrom(Moment.of(Year.of(2019)), Moment.of(Year.of(2020)));

        Interval<Year> target = Interval.createFrom(Moment.of(Year.of(2020)), Moment.of(Year.of(2022)));

        boolean actual = target.isOverlap(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void isOverlap5() {
        Interval<Year> arg = Interval.createFrom(Moment.of(Year.of(2022)), Moment.of(Year.of(2024)));

        Interval<Year> target = Interval.createFrom(Moment.of(Year.of(2020)), Moment.of(Year.of(2022)));

        boolean actual = target.isOverlap(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void isOverlap6() {
        Interval<Year> arg = Interval.createFrom(Moment.of(Year.of(2017)), Moment.of(Year.of(2019)));

        Interval<Year> target = Interval.createFrom(Moment.of(Year.of(2020)), Moment.of(Year.of(2022)));

        boolean actual = target.isOverlap(arg);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    public void isOverlap7() {
        Interval<Year> arg = Interval.createFrom(Moment.of(Year.of(2023)), Moment.of(Year.of(2015)));

        Interval<Year> target = Interval.createFrom(Moment.of(Year.of(2020)), Moment.of(Year.of(2022)));

        boolean actual = target.isOverlap(arg);

        assertThat(actual)
                .isFalse();

    }

    public static class IntervalMock {

        public static Interval<Year> y2020To2023() {
            return Interval.createFrom(Moment.of(Year.of(2020)), Moment.of(Year.of(2022)));

        }

    }


}
