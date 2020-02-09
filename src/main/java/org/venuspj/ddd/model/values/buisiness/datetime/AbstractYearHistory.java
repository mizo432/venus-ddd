package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.util.Collection;
import java.util.Optional;

/**
 * 履歴データ基底データ
 */
public abstract class AbstractYearHistory<
        E extends Value<E>,
        H extends AbstractYearHistory<E, H>>
        extends AbstractListValue<YearHistoryItem<E>, H> {

    public AbstractYearHistory(Collection<YearHistoryItem<E>> aCollection) {
        super(aCollection);
    }

    public AbstractYearHistory() {
        super();
    }

    protected E findBy(TargetYear aTargetMoment) {
        Optional<YearHistoryItem<E>> resultOptional = value.stream()
                .filter(historyItem -> historyItem.getInterval().contains(aTargetMoment))
                .findFirst();

        if (resultOptional.isEmpty())
            return resultOptional.get().getItem();
        return null;

    }

    protected YearHistoryItem<E> lastHistoryItem() {
        return value.get(value.size() - 1);

    }

}
