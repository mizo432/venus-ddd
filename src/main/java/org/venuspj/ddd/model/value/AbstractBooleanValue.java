package org.venuspj.ddd.model.value;

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
