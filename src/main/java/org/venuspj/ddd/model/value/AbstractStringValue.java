package org.venuspj.ddd.model.value;

import java.time.LocalDateTime;

import static org.venuspj.util.objects2.Objects2.equal;

public class AbstractStringValue<ASV extends AbstractStringValue<ASV>>
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
