package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.util.Collection;

/**
 * エンティティリストの基底クラス
 *
 * @param <E>  エンティティ
 * @param <EI> エンティティID
 * @param <AE> エンティティリスト
 */
public abstract class AbstractEntities<E extends AbstractEntity<E, EI, ?>, EI extends EntityIdentifier<E, EI>, AE extends AbstractEntities<E, EI, AE>> extends AbstractListValue<E, AE> {

    protected AbstractEntities() {
        super();

    }

    protected AbstractEntities(Collection<E> anCollection) {
        super(anCollection);

    }

}
