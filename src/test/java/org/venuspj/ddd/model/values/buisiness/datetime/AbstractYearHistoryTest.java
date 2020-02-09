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
    public void createFrom() {
        List<YearHistoryItem<ConcreteValue>> arg = ConcreteYearHistoryMock.fullYearHistoryItemList();
        ConcreteYearHistory target = ConcreteYearHistory.createFrom(arg);

        boolean actual = target.isEmpty();

        System.out.println(target.toString());
        assertThat(actual)
                .isFalse();

    }

    public static class ConcreteYearHistoryMock {

        public static List<YearHistoryItem<ConcreteValue>> fullYearHistoryItemList() {
            return newArrayList(YearHistoryItemTest.YearHistoryItemMock.one(),
                    YearHistoryItemTest.YearHistoryItemMock.two(),
                    YearHistoryItemTest.YearHistoryItemMock.three(),
                    YearHistoryItemTest.YearHistoryItemMock.four(),
                    YearHistoryItemTest.YearHistoryItemMock.five());
        }
    }
}
