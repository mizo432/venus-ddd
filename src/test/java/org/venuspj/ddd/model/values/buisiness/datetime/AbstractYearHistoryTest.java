package org.venuspj.ddd.model.values.buisiness.datetime;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.forTest.model.values.buisiness.datetime.ConcreteValue;
import org.venuspj.ddd.model.forTest.model.values.buisiness.datetime.ConcreteYearHistory;
import org.venuspj.tests.constants.TestSize;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class AbstractYearHistoryTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        ConcreteYearHistory target = ConcreteYearHistory.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();


    }

    @Test
    @Tag(TestSize.SMALL)
    public void createFrom1() {
        List<YearHistoryItem<ConcreteValue>> arg = ConcreteYearHistoryMock.fullYearHistoryItemListCreateFromStartDate();
        ConcreteYearHistory target = ConcreteYearHistory.createFrom(arg);

        boolean actual = target.isEmpty();

        System.out.println(target.toString());
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void createFrom2() {
        List<YearHistoryItem<ConcreteValue>> arg =
                ConcreteYearHistoryMock.fullYearHistoryItemListCreateFromMoment();

        ConcreteYearHistory target = ConcreteYearHistory.createFrom(arg);

        boolean actual = target.isEmpty();

        System.out.println(target.toString());
        assertThat(actual)
                .isFalse();

    }

    public static class ConcreteYearHistoryMock {

        public static List<YearHistoryItem<ConcreteValue>> fullYearHistoryItemListCreateFromStartDate() {
            return newArrayList(YearHistoryItemTest.YearHistoryItemMock.one(),
                    YearHistoryItemTest.YearHistoryItemMock.two(),
                    YearHistoryItemTest.YearHistoryItemMock.three(),
                    YearHistoryItemTest.YearHistoryItemMock.four(),
                    YearHistoryItemTest.YearHistoryItemMock.five());
        }

        public static List<YearHistoryItem<ConcreteValue>> fullYearHistoryItemListCreateFromMoment() {
            return newArrayList(YearHistoryItemTest.YearHistoryItemMock.six(),
                    YearHistoryItemTest.YearHistoryItemMock.seven(),
                    YearHistoryItemTest.YearHistoryItemMock.eight(),
                    YearHistoryItemTest.YearHistoryItemMock.nine(),
                    YearHistoryItemTest.YearHistoryItemMock.ten(),
                    YearHistoryItemTest.YearHistoryItemMock.eleven()
            );
        }
    }
}
