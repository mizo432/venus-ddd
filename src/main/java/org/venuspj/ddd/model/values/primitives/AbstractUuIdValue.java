package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractSingleValue;

import java.util.UUID;

import static org.venuspj.util.objects2.Objects2.isNull;

public class AbstractUuIdValue<AUV extends AbstractUuIdValue<AUV>> extends AbstractSingleValue<UUID, AUV> implements UuidValue<AUV> {

    @Override
    public int compareTo(AUV o) {
        if (isNull(o)) {
            return -1;
        }
        return value.compareTo(o.value);
    }

    @Override
    public UUID asUUID() {
        return value;
    }
}
