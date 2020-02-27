package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.primitives.momentinterval.StartYear;
import org.venuspj.tests.constants.TestSize;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class HistoryItemTest {

    @Test
    @Tag(TestSize.SMALL)
    public void createFrom1() {
        HistoryItem<Year, StartYear> target = HistoryItemMock.one();
        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void getItem() {
        HistoryItem<Year, StartYear> target = HistoryItemMock.one();
        StartYear actual = target.getItem();

        assertThat(actual)
                .isEqualTo(StartYear.of(Year.of(1900)));

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void getInterval() {
        HistoryItem<Year, StartYear> target = HistoryItemMock.one();
        Interval<Year> actual = target.getInterval();

        assertThat(actual)
                .isEqualTo(IntervalTest.IntervalMock.y2020To2023());

        System.out.println(target.toString());

    }

    public static class HistoryItemMock {

        static HistoryItem<Year, StartYear> one() {
            return HistoryItem.createFrom(IntervalTest.IntervalMock.y2020To2023(), StartYear.of(Year.of(1900)));
        }

    }

}
