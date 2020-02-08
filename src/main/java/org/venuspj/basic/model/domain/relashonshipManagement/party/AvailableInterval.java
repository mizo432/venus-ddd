package org.venuspj.basic.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.values.Value;

public class AvailableInterval implements Value<AvailableInterval> {
    @Override
    public boolean sameValueAs(AvailableInterval other) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}
