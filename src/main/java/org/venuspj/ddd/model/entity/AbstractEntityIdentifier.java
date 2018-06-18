package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.value.Value;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.hash;

/**
 * {@link EntityIdentifier}のデフォルト基底クラス.
 *
 * @param <E>   エンティティの型。コンパイル時のみ利用
 * @param <AEI> AbstractEntityIdentifierの型
 * @param <T>   identifireの型
 */
public abstract class AbstractEntityIdentifier<E extends Entity<E, AEI>, AEI extends AbstractEntityIdentifier<E, AEI, T>, T extends Value<T>>
        implements EntityIdentifier<E, AEI> {

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
        return o instanceof AbstractEntityIdentifier && sameValueAs((AEI) o);

    }

    @Override
    public boolean sameValueAs(AEI other) {
        return equal(kind, other.kind) && equal(value, other.value);

    }

    @Override
    public int hashCode() {
        return hash(kind, value);

    }

}
