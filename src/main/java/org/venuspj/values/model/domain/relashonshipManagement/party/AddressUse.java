package org.venuspj.values.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.values.buisiness.datetime.Interval;
import org.venuspj.util.base.Preconditions;

import java.time.YearMonth;

public class AddressUse extends AbstractEntity<AddressUse, AddressUseIdentifier> {
    private Interval<YearMonth> interval;

    protected AddressUse(AddressUseIdentifier anIdentifier, Interval<YearMonth> anInterval) {
        super(anIdentifier);
        Preconditions.checkNotNull(anInterval);
        interval = anInterval;

    }

}
