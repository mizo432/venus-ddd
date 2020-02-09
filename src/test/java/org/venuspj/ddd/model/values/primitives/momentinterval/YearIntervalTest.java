package org.venuspj.ddd.model.values.primitives.momentinterval;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.datetime.TargetYear;
import org.venuspj.tests.constants.TestSize;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class YearIntervalTest {


    @Test
    @Tag(TestSize.SMALL)
    public void createFrom1() {

        YearInterval target
                = YearInterval
                .createFrom(
                        StartYear.of(Year.of(2019))
                        , EndYear.of(Year.of(2020)));

        System.out.println(target.toString());


    }

    @Test
    @Tag(TestSize.SMALL)
    public void createFrom2() {

        YearInterval target
                = YearInterval
                .createFrom(
                        StartYear.of(Year.of(2019)));

        System.out.println(target.toString());


    }

    @Test
    @Tag(TestSize.SMALL)
    public void contains1() {

        YearInterval target
                = YearInterval
                .createFrom(
                        StartYear.of(Year.of(2017))
                        , EndYear.of(Year.of(2020)));

        TargetYear targetYear = TargetYear.of(Year.of(2018));

        boolean actual = target.contains(targetYear);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void contains2() {

        YearInterval target
                = YearInterval
                .createFrom(
                        StartYear.of(Year.of(2017))
                        , EndYear.of(Year.of(2020)));

        TargetYear targetYear = TargetYear.of(Year.of(2017));

        boolean actual = target.contains(targetYear);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void contains3() {

        YearInterval target
                = YearInterval
                .createFrom(
                        StartYear.of(Year.of(2017))
                        , EndYear.of(Year.of(2020)));

        TargetYear targetYear = TargetYear.of(Year.of(2020));

        boolean actual = target.contains(targetYear);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void contains4() {

        YearInterval target
                = YearInterval
                .createFrom(
                        StartYear.of(Year.of(2017))
                        , EndYear.of(Year.of(2020)));

        TargetYear targetYear = TargetYear.of(Year.of(2016));

        boolean actual = target.contains(targetYear);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void contains5() {

        YearInterval target
                = YearInterval
                .createFrom(
                        StartYear.of(Year.of(2017))
                        , EndYear.of(Year.of(2020)));

        TargetYear targetYear = TargetYear.of(Year.of(2021));

        boolean actual = target.contains(targetYear);

        assertThat(actual)
                .isFalse();

    }

}
