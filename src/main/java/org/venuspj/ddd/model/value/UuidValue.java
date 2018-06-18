package org.venuspj.ddd.model.value;

import java.util.UUID;

public interface UuidValue<T extends UuidValue<T>> extends Value<T> {
    UUID asUUID();
}
