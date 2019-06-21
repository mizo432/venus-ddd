package org.venuspj.ddd.model.entity;

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
     * @return {@link AbstractEntityIdentifier}
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

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object o) {
        return o instanceof AbstractEntityIdentifier && sameValueAs((EI) o);

    }

    @Override
    public abstract boolean sameValueAs(EI other);

    @Override
    public String getKind() {
        return kind;
    }

}
