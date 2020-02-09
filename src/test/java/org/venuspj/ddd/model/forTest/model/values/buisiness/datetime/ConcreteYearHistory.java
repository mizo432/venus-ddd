package org.venuspj.ddd.model.forTest.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.buisiness.datetime.AbstractYearHistory;
import org.venuspj.ddd.model.values.buisiness.datetime.YearHistoryItem;

import java.util.Collection;
import java.util.List;

import static org.venuspj.util.collect.Lists2.newArrayList;

public class ConcreteYearHistory extends AbstractYearHistory<ConcreteValue, ConcreteYearHistory> {

    public ConcreteYearHistory(Collection<YearHistoryItem<ConcreteValue>> aCollection) {
        super(aCollection);

    }

    public ConcreteYearHistory() {
        super();
    }

    public static ConcreteYearHistory empty() {
        return new ConcreteYearHistory();

    }

    public static ConcreteYearHistory createFrom(List<YearHistoryItem<ConcreteValue>> anyArg) {
        ConcreteYearHistory result = ConcreteYearHistory.empty();
        for (YearHistoryItem<ConcreteValue> yearHistoryItem : anyArg) {
            if (result.isEmpty())
                result = new ConcreteYearHistory(newArrayList(yearHistoryItem));
            else {
                YearHistoryItem<ConcreteValue> lastItem = result.lastHistoryItem();
                if (lastItem.sameItemAs(yearHistoryItem)) {
                    if (lastItem.isOverlap(yearHistoryItem)) {

                    }

                }


                if (!lastItem.sameItemAs(yearHistoryItem)) {
                    List<YearHistoryItem<ConcreteValue>> addList = newArrayList();
                    for (int i = 0; i < result.size() - 1; i++) {
                        addList.add(result.getValue().get(i));

                    }
                    YearHistoryItem<ConcreteValue> renew = lastItem.renewEndDate(yearHistoryItem.decrementStartMoment());
                    addList.add(renew);
                    addList.add(yearHistoryItem);
                    result = new ConcreteYearHistory(addList);

                }
            }
        }
        return result;
    }
}
