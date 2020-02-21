package org.venuspj.ddd.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.AbstractValue;

import static org.venuspj.util.objects2.Objects2.*;

/**
 * {@link EntityIdentifier}のデフォルト基底クラス.
 *
 * @param <EI> EntityIdentifierの型
 * @param <V>  IDとして保持する型
 */
public abstract class AbstractEntityIdentifier<EI extends AbstractEntityIdentifier<EI, V>, V>
        extends AbstractValue<EI>
        implements EntityIdentifier<EI>,
        Comparable<EI> {

    protected String kind;
    private V value;

    /**
     * インスタンスを生成する。
     *
     * @param entityClass エンティティクラス。カインドにはFQCNが設定される。
     */
    protected AbstractEntityIdentifier(Class<?> entityClass) {
        this(entityClass.getCanonicalName());

    }

    /**
     * インスタンスを生成する。
     *
     * @param entityClass エンティティクラス。カインドにはFQCNが設定される。
     */
    protected AbstractEntityIdentifier(Class<?> entityClass, V aValue) {
        this(entityClass.getCanonicalName());
        value = aValue;

    }

    /**
     * インスタンスを生成する。
     *
     * @param kind カインド
     */
    private AbstractEntityIdentifier(String kind) {
        this.kind = kind;

    }


    @Override
    @JsonIgnore
    public String getKind() {
        return kind;

    }

    public String asText() {
        return value.toString();

    }

    public V getValue() {
        return value;

    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return isNull(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntityIdentifier<?, ?> that = (AbstractEntityIdentifier<?, ?>) o;
        return equal(kind, that.kind) &&
                equal(value, that.value);
    }

    @Override
    public int hashCode() {
        return hash(kind, value);

    }

    @Override
    public boolean sameValueAs(EI other) {
        return equals(other);

    }

    @Override
    public int compareTo(EI identifier) {
        if (isNull(kind))
            return -1;
        if (isNull(value))
            return -1;
        return compareTo((EI) value);
    }
}
