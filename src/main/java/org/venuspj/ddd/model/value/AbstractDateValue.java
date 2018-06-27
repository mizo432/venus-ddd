package org.venuspj.ddd.model.value;

import java.time.LocalDate;

public abstract class AbstractDateValue<ASV extends AbstractDateValue<ASV>>
        extends AbstractSingleValue<ASV, LocalDate> implements DateValue<ASV> {

    protected AbstractDateValue() {
    }

    protected AbstractDateValue(LocalDate value) {
        super(value);

    }

    @Override
    public String asText() {
        return value.toString();
    }

    @Override
    public LocalDate asDate() {
        return value;
    }

}