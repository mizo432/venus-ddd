package org.venuspj.ddd.model.values;

import org.venuspj.ddd.model.values.primitives.SingleValue;

import static org.venuspj.util.objects2.Objects2.*;

/**
 * 単値オブジェクト.
 *
 * @param <T>   保持データ型
 * @param <ASV> 単値オブジェクト
 */
public abstract class AbstractSingleValue<T, ASV extends AbstractSingleValue<T, ASV>> implements SingleValue<T, ASV>, Comparable<ASV> {

    protected T value;

    public AbstractSingleValue() {

    }

    protected AbstractSingleValue(T aValue) {
        value = aValue;

    }

    @Override
    public T getValue() {
        return value;
    }

    public boolean sameValueAs(ASV that) {
        if (isNull(that))
            return false;

        return org.venuspj.util.objects2.Objects2.equal(value, that.value);
    }

    @Override
    public int hashCode() {
        return org.venuspj.util.objects2.Objects2.hash(value);

    }

    public String asText() {
        if (isNull(value))
            return null;
        return value.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ASV that = (ASV) o;
        return sameValueAs(that);
    }

    @Override
    public abstract int compareTo(ASV o);

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();

    }

    public boolean isEmpty() {
        return isNull(value);
    }

    public boolean isPresent() {
        return nonNull(value);
    }

}
