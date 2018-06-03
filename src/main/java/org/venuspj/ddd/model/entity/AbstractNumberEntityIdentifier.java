package org.venuspj.ddd.model.entity;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.hash;

/**
 * {@link EntityIdentifier}のデフォルト実装。
 *
 * @param <T> エンティティの型。コンパイル時のみ利用。
 */
public class AbstractNumberEntityIdentifier<T extends Entity<T>> extends AbstractEntityIdentifier<T> implements EntityIdentifier<T> {


    public void setValue(Integer value) {
        this.value = value;
    }

    private Integer value = -1;

    /**
     * インスタンスを生成する。
     *
     * @param anEntityClass エンティティクラス。カインドにはFQCNが設定される。
     * @return {@link AbstractNumberEntityIdentifier}
     */
    protected AbstractNumberEntityIdentifier(Class<?> anEntityClass, Integer aValue) {
        this(anEntityClass.getCanonicalName(), aValue);
        value = aValue;
    }

    /**
     * インスタンスを生成する。
     *
     * @param aKind カインド
     */
    protected AbstractNumberEntityIdentifier(String aKind, Integer aValue) {
        kind = aKind;
        value = aValue;
    }

    protected AbstractNumberEntityIdentifier(Class<?> anEntityClass) {
        this(anEntityClass, -1);

    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof AbstractNumberEntityIdentifier &&
                equal(((AbstractNumberEntityIdentifier) o).kind, kind) &&
                equal(((AbstractNumberEntityIdentifier) o).value, value);
    }

    @Override
    public int hashCode() {
        return hash(kind, value);
    }

    @Override
    public boolean sameValueAs(EntityIdentifier<T> other) {
        return equals(other);
    }

}
