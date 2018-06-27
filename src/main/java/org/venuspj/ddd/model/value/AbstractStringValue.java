package org.venuspj.ddd.model.value;

public abstract class AbstractStringValue<ASV extends AbstractStringValue<ASV>>
        extends AbstractSingleValue<ASV, String> implements StringValue<ASV> {

    protected AbstractStringValue() {
    }

    protected AbstractStringValue(String value) {
        super(value);

    }

    @Override
    public String asText() {
        return value;
    }

    @Override
    public String getValue() {
        return value;
    }

}
