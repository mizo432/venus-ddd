package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.forTest.model.values.buisiness.datetime.ConcreteValue;
import org.venuspj.ddd.model.values.buisiness.Name;
import org.venuspj.ddd.model.values.primitives.momentinterval.StartYear;
import org.venuspj.ddd.model.values.primitives.momentinterval.YearInterval;
import org.venuspj.tests.constants.TestSize;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

public class YearHistoryItemTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        YearHistoryItem<ConcreteValue> target = YearHistoryItem.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();


    }

    @Test
    @Tag(TestSize.SMALL)
    public void createFrom() {
        YearHistoryItem<ConcreteValue> target = YearHistoryItemMock.full();

        boolean actual = target.isEmpty();

        System.out.println(target.toString());

        assertThat(actual)
                .isFalse();


    }

    public static class YearHistoryItemMock {

        public static YearHistoryItem<ConcreteValue> full() {
            YearInterval anYearInterval = YearInterval.createFrom(StartYear.of(Year.of(2020)));
            return YearHistoryItem.createFrom(anYearInterval, ConcreteValue.createFrom(Name.of("漢字"), Name.of("かな")));

        }

        public static YearHistoryItem<ConcreteValue> one() {
            YearInterval anYearInterval = YearInterval.createFrom(StartYear.of(Year.of(2020)));
            return YearHistoryItem.createFrom(anYearInterval, ConcreteValue.createFrom(Name.of("漢字"), Name.of("かな")));

        }

        public static YearHistoryItem<ConcreteValue> two() {
            YearInterval anYearInterval = YearInterval.createFrom(StartYear.of(Year.of(2021)));
            return YearHistoryItem.createFrom(anYearInterval, ConcreteValue.createFrom(Name.of("漢字"), Name.of("かな")));

        }

        public static YearHistoryItem<ConcreteValue> three() {
            YearInterval anYearInterval = YearInterval.createFrom(StartYear.of(Year.of(2023)));
            return YearHistoryItem.createFrom(anYearInterval, ConcreteValue.createFrom(Name.of("漢字"), Name.of("かな")));

        }

        public static YearHistoryItem<ConcreteValue> four() {
            YearInterval anYearInterval = YearInterval.createFrom(StartYear.of(Year.of(2025)));
            return YearHistoryItem.createFrom(anYearInterval, ConcreteValue.createFrom(Name.of("漢字1"), Name.of("かな1")));

        }

        public static YearHistoryItem<ConcreteValue> five() {
            YearInterval anYearInterval = YearInterval.createFrom(StartYear.of(Year.of(2027)));
            return YearHistoryItem.createFrom(anYearInterval, ConcreteValue.createFrom(Name.of("漢字"), Name.of("かな")));

        }
    }

}
