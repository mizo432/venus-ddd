package org.venuspj.ddd.model.entity;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.hash;

/**
 * {@link EntityIdentifier}のデフォルト基底クラス.
 *
 * @param <E>  エンティティの型。コンパイル時のみ利用
 * @param <EI> EntityIdentifierの型
 * @param <T>  Identifierの型
 */
public abstract class AbstractEntityIdentifier<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI, T>, T>
        implements EntityIdentifier<E, EI, T> {

    protected String kind;

    protected T value;


    /**
     * インスタンスを生成する。
     *
     * @param entityClass エンティティクラス。カインドにはFQCNが設定される。
     * @return {@link AbstractEntityIdentifier}
     */
    protected AbstractEntityIdentifier(Class<E> entityClass) {
        this(entityClass.getCanonicalName());
    }

    /**
     * インスタンスを生成する。
     *
     * @param entityClass エンティティクラス。カインドにはFQCNが設定される。
     * @param keyValue
     */
    protected AbstractEntityIdentifier(Class<E> entityClass, T keyValue) {
        this(entityClass);
        this.value = keyValue;
    }

    /**
     * インスタンスを生成する。
     *
     * @param kind カインド
     */
    protected AbstractEntityIdentifier(String kind) {
        this.kind = kind;
    }

    /**
     * インスタンスを生成する.
     *
     * @param kind     カインド
     * @param keyValue キー値
     */
    protected AbstractEntityIdentifier(String kind, T keyValue) {
        this(kind);
        this.value = keyValue;
    }

    protected AbstractEntityIdentifier() {

    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        return o instanceof AbstractEntityIdentifier && sameValueAs((EI) o);

    }

    @Override
    public boolean sameValueAs(EI other) {
        return equal(kind, other.getKind()) && equal(value, other.getValue());

    }

    @Override
    public int hashCode() {
        return hash(kind, value);

    }

    @Override
    public String getKind() {
        return kind;
    }

    @Override
    public T getValue() {
        return value;
    }
}
