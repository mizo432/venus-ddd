package org.venuspj.basic.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.values.primitives.momentinterval.YearMonthInterval;

public class AddressUse extends AbstractEntity<AddressUse, AddressUseIdentifier> {
    private YearMonthInterval interval = YearMonthInterval.empty();

    protected AddressUse(AddressUseIdentifier anIdentifier, YearMonthInterval anInterval) {
        super(anIdentifier);
        interval = anInterval;
    }

}
