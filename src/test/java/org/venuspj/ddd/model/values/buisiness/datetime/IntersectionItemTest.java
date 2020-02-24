package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.primitives.momentinterval.EndYear;
import org.venuspj.ddd.model.values.primitives.momentinterval.StartYear;
import org.venuspj.tests.constants.TestSize;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class IntersectionItemTest {
    @Test
    @Tag(TestSize.SMALL)
    public void createFrom1() {
        IntersectionItem<Year, StartYear, EndYear> target = IntersectionItemMock.one();
        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void getFirstValue() {
        IntersectionItem<Year, StartYear, EndYear> target = IntersectionItemMock.one();
        StartYear actual = target.getFirstValue();

        assertThat(actual)
                .isEqualTo(StartYear.of(Year.of(1900)));

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void getSecondValue() {
        IntersectionItem<Year, StartYear, EndYear> target = IntersectionItemMock.one();
        EndYear actual = target.getSecondValue();

        assertThat(actual)
                .isEqualTo(EndYear.of(Year.of(1901)));

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void getInterval() {
        IntersectionItem<Year, StartYear, EndYear> target = IntersectionItemMock.one();
        Interval<Year> actual = target.getInterval();

        assertThat(actual)
                .isEqualTo(IntervalTest.IntervalMock.y2020To2023());

        System.out.println(target.toString());

    }

    public static class IntersectionItemMock {

        static IntersectionItem<Year, StartYear, EndYear> one() {
            return IntersectionItem.createFrom(IntervalTest.IntervalMock.y2020To2023(),
                    StartYear.of(Year.of(1900)),
                    EndYear.of(Year.of(1901)));
        }

    }

}
