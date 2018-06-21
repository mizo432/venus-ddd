package org.venuspj.ddd.model.value;

import java.time.LocalDate;

import static org.venuspj.util.objects2.Objects2.hash;

public abstract class AbstractBooleanValue<ABV extends AbstractBooleanValue<ABV>>
        extends AbstractSingleValue<ABV, Boolean> implements BooleanValue<ABV> {

    protected AbstractBooleanValue() {
    }

    protected AbstractBooleanValue(Boolean value) {
        super(value);

    }


    @Override
    public String asText() {
        return value.toString();
    }

    @Override
    public Boolean asBoolean() {
        return value;
    }

}
