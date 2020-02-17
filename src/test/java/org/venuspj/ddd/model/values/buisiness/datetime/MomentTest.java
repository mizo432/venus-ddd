package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    @Tag(TestSize.SMALL)
    public void maxOf1() {
        Moment<Year> target = Moment.maxOf(TemporalType.YEAR);
        System.out.println(target);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void maxOf2() {
        Moment<YearMonth> target = Moment.maxOf(TemporalType.YEAR_MONTH);
        System.out.println(target);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void maxOf3() {
        Moment<YearMonth> target = Moment.maxOf(TemporalType.DATE);
        System.out.println(target);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void maxOf4() {
        Moment<YearMonth> target = Moment.maxOf(TemporalType.DATE_TIME);
        System.out.println(target);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isAfter1() {
        Moment<Year> arg = Moment.of(Year.of(2020));
        Moment<Year> target = Moment.of(Year.of(2020));

        boolean actual = target.isAfter(arg);

        assertThat(actual)
                .isFalse();

        System.out.println(target);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isAfter2() {
        Moment<Year> arg = Moment.of(Year.of(2019));
        Moment<Year> target = Moment.of(Year.of(2020));

        boolean actual = target.isAfter(arg);

        assertThat(actual)
                .isTrue();

        System.out.println(target);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isAfter3() {
        Moment<Year> arg = Moment.of(Year.of(2021));
        Moment<Year> target = Moment.of(Year.of(2020));

        boolean actual = target.isAfter(arg);

        assertThat(actual)
                .isFalse();

        System.out.println(target);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isBefore1() {
        Moment<Year> arg = Moment.of(Year.of(2020));
        Moment<Year> target = Moment.of(Year.of(2020));

        boolean actual = target.isBefore(arg);

        assertThat(actual)
                .isFalse();

        System.out.println(target);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isBefore2() {
        Moment<Year> arg = Moment.of(Year.of(2019));
        Moment<Year> target = Moment.of(Year.of(2020));

        boolean actual = target.isBefore(arg);

        assertThat(actual)
                .isFalse();

        System.out.println(target);

    }

    @Test
    @Tag(TestSize.SMALL)
    public void isBefore3() {
        Moment<Year> arg = Moment.of(Year.of(2021));
        Moment<Year> target = Moment.of(Year.of(2020));

        boolean actual = target.isBefore(arg);

        assertThat(actual)
                .isTrue();

        System.out.println(target);

    }

}
