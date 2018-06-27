package org.venuspj.ddd.model.value;

import java.time.LocalDateTime;

public interface BooleanValue<T extends BooleanValue<T>> extends Value<T> {
    Boolean asBoolean();

    Boolean getValue();

}
