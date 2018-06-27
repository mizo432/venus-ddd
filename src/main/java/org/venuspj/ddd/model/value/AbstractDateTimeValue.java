package org.venuspj.ddd.model.value;

import java.time.LocalDateTime;

public abstract class AbstractDateTimeValue<ASV extends AbstractDateTimeValue<ASV>>
        extends AbstractSingleValue<ASV, LocalDateTime> implements DateTimeValue<ASV> {

    protected AbstractDateTimeValue() {
    }

    protected AbstractDateTimeValue(LocalDateTime value) {
        this.value = value;

    }


    @Override
    public String asText() {
        return value.toString();

    }

    @Override
    public LocalDateTime asDateTime() {
        return value;

    }

}
