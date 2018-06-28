package org.venuspj.ddd.model.value;

import java.time.LocalDateTime;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.hash;

public abstract class AbstractSingleValue<ASV extends AbstractSingleValue<ASV, T>, T> implements Value<ASV> {
    protected T value;

    protected AbstractSingleValue() {
    }

    protected AbstractSingleValue(T value) {
        this.value = value;

    }


    public abstract String asText();

    public T getValue() {
        return value;

    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        return obj instanceof AbstractSingleValue &&
                sameValueAs((ASV) obj);
    }

    @Override
    public boolean sameValueAs(ASV other) {
        return equal(this.value, other.value);

    }

    @Override
    public int hashCode() {
        return hash(value);
    }

}
