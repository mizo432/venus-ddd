package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

import java.util.UUID;

public interface UuidValue<T extends UuidValue<T>> extends SingleValue<UUID, T> {
    UUID asUUID();

    String asText();

}
