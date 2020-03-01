package org.venuspj.ddd.model.entity;

/**
 * {@link EntityLongIdentifier}のデフォルト基底クラス.
 *
 * @param <EI> EntityIdentifierの型
 */
public abstract class AbstractEntityLongIdentifier<EI extends AbstractEntityLongIdentifier<EI>>
        extends AbstractEntityIdentifier<EI, Long> {

    /**
     * インスタンスを生成する。
     *
     * @param entityClass エンティティクラス。カインドにはFQCNが設定される。
     */
    protected AbstractEntityLongIdentifier(Class<?> entityClass, Long aValue) {
        super(entityClass, aValue);

    }

    /**
     * インスタンスを生成する。
     *
     * @param entityClass エンティティクラス。カインドにはFQCNが設定される。
     */
    protected AbstractEntityLongIdentifier(Class<?> entityClass) {
        super(entityClass);

    }


    public Long asLong() {
        return getValue();

    }

    @Override
    public String asText() {
        return getValue().toString();

    }

}
