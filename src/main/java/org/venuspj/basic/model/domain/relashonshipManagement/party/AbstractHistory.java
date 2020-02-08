package org.venuspj.basic.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.datetime.TargetDate;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

/**
 * 履歴データ基底データ
 */
public class AbstractHistory<
        E extends Value<E>,
        H extends AbstractHistory<E, H>>
        extends AbstractListValue<HistoryItem<E>, H> {

    public E findBy(TargetDate aTargetDate) {
        return null;

    }

}
