package org.venuspj.ddd.model.entity;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.hash;

/**
 * {@link EntityIdentifier}のデフォルト実装。
 *
 * @param <T> エンティティの型。コンパイル時のみ利用。
 */
public abstract class AbstractEntityIdentifier<T extends Entity<T>> implements EntityIdentifier<T> {

    protected String kind;

    /**
     * インスタンスを生成する。
     *
     * @param anEntityClass エンティティクラス。カインドにはFQCNが設定される。
     * @return {@link AbstractEntityIdentifier}
     */
    protected AbstractEntityIdentifier(Class<?> anEntityClass) {
        this(anEntityClass.getCanonicalName());
    }

    /**
     * インスタンスを生成する。
     *
     * @param aKind カインド
     */
    protected AbstractEntityIdentifier(String aKind) {
        this();
        kind = aKind;
    }

    protected AbstractEntityIdentifier() {

    }

    @Override
    public boolean equals(Object o) {
        return o instanceof AbstractEntityIdentifier &&
                equal(((AbstractEntityIdentifier) o).kind, kind);
    }

    @Override
    public int hashCode() {
        return hash(kind);
    }

}
