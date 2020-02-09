package org.venuspj.ddd.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static java.util.Objects.hash;
import static org.venuspj.util.objects2.Objects2.*;

/**
 * {@link EntityIdentifier}のデフォルト基底クラス.
 *
 * @param <E>  エンティティの型。コンパイル時のみ利用
 * @param <EI> EntityIdentifierの型
 */
public abstract class AbstractEntityLongIdentifier<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI>>
        extends AbstractEntityIdentifier<E, EI> {
    protected Long value;

    /**
     * インスタンスを生成する。
     *
     * @param entityClass エンティティクラス。カインドにはFQCNが設定される。
     */
    protected AbstractEntityLongIdentifier(Class<E> entityClass, Long aValue) {
        super(entityClass);
        value = aValue;

    }

    /**
     * インスタンスを生成する。
     *
     * @param entityClass エンティティクラス。カインドにはFQCNが設定される。
     */
    protected AbstractEntityLongIdentifier(Class<E> entityClass) {
        super(entityClass);

    }

    /**
     * インスタンスを生成する。
     *
     * @param kind カインド
     */
    protected AbstractEntityLongIdentifier(String kind) {
        this.kind = kind;

    }

    /**
     * インスタンスを生成する。
     *
     * @param kind カインド
     */
    protected AbstractEntityLongIdentifier(String kind, Long aValue) {
        super(kind);
        value = aValue;


    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return isNull(value);

    }

    @Override
    public Long asLong() {
        return value;

    }

    @Override
    public String asText() {
        return value.toString();

    }

    @Override
    public Long getValue() {
        return value;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AbstractEntityLongIdentifier<?, ?> that = (AbstractEntityLongIdentifier<?, ?>) o;
        return equal(value, that.value);
    }

    @Override
    public int hashCode() {
        return hash(kind, value);

    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();
    }
}
