package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.primitives.momentinterval.EndYear;
import org.venuspj.ddd.model.values.primitives.momentinterval.StartYear;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class IntersectionItemTest {
    @Test
    @Tag("small")
    public void createFrom1() {
        IntersectionItem<Year, StartYear, EndYear> target = IntersectionItemMock.one();
        System.out.println(target.toString());

    }

    @Test
    @Tag("small")
    public void getFirstValue() {
        IntersectionItem<Year, StartYear, EndYear> target = IntersectionItemMock.one();
        StartYear actual = target.getFirstValue();

        assertThat(actual)
                .isEqualTo(StartYear.of(Year.of(1900)));

        System.out.println(target.toString());

    }

    @Test
    @Tag("small")
    public void getSecondValue() {
        IntersectionItem<Year, StartYear, EndYear> target = IntersectionItemMock.one();
        EndYear actual = target.getSecondValue();

        assertThat(actual)
                .isEqualTo(EndYear.of(Year.of(1901)));

        System.out.println(target.toString());

    }

    @Test
    @Tag("small")
    public void getInterval() {
        IntersectionItem<Year, StartYear, EndYear> target = IntersectionItemMock.one();
        Interval<Year> actual = target.getInterval();

        assertThat(actual)
                .isEqualTo(IntervalTest.IntervalMock.y2020To2023());

        System.out.println(target.toString());

    }

    @Test
    @Tag("small")
    public void intersectionBuilderBuild1() {
        IntersectionItem.IntersectionBuilder<Year, StartYear, EndYear> builder = IntersectionItem.builder();
        IntersectionItem<Year, StartYear, EndYear> target =
                builder
                        .withStartMoment(Moment.of(Year.of(2020)))
                        .withEndMoment(Moment.of(Year.of(2021)))
                        .withFirstValue(StartYear.of(Year.of(2030)))
                        .withSecondValue(EndYear.of(Year.of(2030)))
                        .build();

        assertThat(target)
                .isNotNull();

    }

    @Test
    @Tag("small")
    public void intersectionBuilderBuild2() {
        IntersectionItem.IntersectionBuilder<Year, StartYear, EndYear> builder = IntersectionItem.builder();
        IntersectionItem<Year, StartYear, EndYear> target =
                builder
                        .withStartMoment(Moment.of(Year.of(2020)))
                        .withStartMoment(null)
                        .withEndMoment(Moment.of(Year.of(2021)))
                        .withEndMoment(null)
                        .withFirstValue(StartYear.of(Year.of(2030)))
                        .withFirstValue(null)
                        .withSecondValue(EndYear.of(Year.of(2030)))
                        .withSecondValue(null)
                        .build();

        assertThat(target)
                .isNotNull();

    }

    @Test
    @Tag("small")
    public void intersectionBuilderApply() {
        IntersectionItem.IntersectionBuilder<Year, StartYear, EndYear> builder = IntersectionItem.builder();
        IntersectionItem<Year, StartYear, EndYear> arg =
                builder
                        .withStartMoment(Moment.of(Year.of(2020)))
                        .withEndMoment(Moment.of(Year.of(2021)))
                        .withFirstValue(StartYear.of(Year.of(2030)))
                        .withSecondValue(EndYear.of(Year.of(2030)))
                        .build();

        IntersectionItem.IntersectionBuilder<Year, StartYear, EndYear> builder1 = IntersectionItem.builder();
        IntersectionItem<Year, StartYear, EndYear> actual =
                builder1
                        .withStartMoment(Moment.of(Year.of(2020)))
                        .withEndMoment(Moment.of(Year.of(2021)))
                        .withFirstValue(StartYear.of(Year.of(2030)))
                        .withSecondValue(EndYear.of(Year.of(2030)))
                        .apply(arg);


        assertThat(actual)
                .isNotNull();

    }

    public static class IntersectionItemMock {

        static IntersectionItem<Year, StartYear, EndYear> one() {
            return IntersectionItem.createFrom(IntervalTest.IntervalMock.y2020To2023(),
                    StartYear.of(Year.of(1900)),
                    EndYear.of(Year.of(1901)));
        }

    }

}
