package org.venuspj.ddd.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.util.objects2.Objects2;

/**
 * {@link EntityIdentifier}のデフォルト基底クラス.
 *
 * @param <E>  エンティティの型。コンパイル時のみ利用
 * @param <EI> EntityIdentifierの型
 */
public abstract class AbstractEntityIdentifier<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI>>
        implements EntityIdentifier<E, EI> {

    protected String kind;

    /**
     * インスタンスを生成する。
     *
     * @param entityClass エンティティクラス。カインドにはFQCNが設定される。
     */
    protected AbstractEntityIdentifier(Class<E> entityClass) {
        this(entityClass.getCanonicalName());

    }

    /**
     * インスタンスを生成する。
     *
     * @param kind カインド
     */
    protected AbstractEntityIdentifier(String kind) {
        this.kind = kind;

    }


    protected AbstractEntityIdentifier() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractEntityIdentifier<?, ?> that = (AbstractEntityIdentifier<?, ?>) o;
        return Objects2.equal(kind, that.kind);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(kind);
    }

    @Override
    @JsonIgnore
    public String getKind() {
        return kind;

    }

}
