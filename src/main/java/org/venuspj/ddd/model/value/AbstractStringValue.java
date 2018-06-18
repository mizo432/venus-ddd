package org.venuspj.ddd.model.value;

import static org.venuspj.util.objects2.Objects2.equal;

public class AbstractStringValue<ASV extends AbstractStringValue<ASV>> implements StringValue<ASV> {
    protected String value;

    protected AbstractStringValue() {
    }

    protected AbstractStringValue(String value) {
        this.value = value;

    }

    @Override
    public String asText() {
        return value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public boolean sameValueAs(ASV other) {
        return equal(this.value, other.value);
    }
}
