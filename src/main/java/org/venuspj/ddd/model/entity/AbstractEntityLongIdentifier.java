package org.venuspj.ddd.model.entity;

import static org.venuspj.util.objects2.Objects2.isNull;

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
        super(entityClass.getCanonicalName());
        value = aValue;

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
}
