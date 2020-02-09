package org.venuspj.ddd.model.forTest.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.buisiness.datetime.AbstractYearHistory;
import org.venuspj.ddd.model.values.buisiness.datetime.YearHistoryItem;

import java.util.Collection;
import java.util.List;

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
        return new ConcreteYearHistory(NormalizationHistory
                .of(anyArg)
                .normalize());

    }
}
