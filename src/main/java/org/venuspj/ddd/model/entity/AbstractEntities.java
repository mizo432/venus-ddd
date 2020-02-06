package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.repository.EntityNotFoundRuntimeException;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;
import org.venuspj.ddd.model.values.primitives.ItemNotFoundRuntimeException;

import java.util.Collection;
import java.util.function.Predicate;

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

    /**
     * IDをキーに検索する
     *
     * @param anIdentifier ID
     * @return 検索結果
     * @throws EntityNotFoundRuntimeException 見つからない場合に本例外を投げる
     */
    public E findEntityBy(EI anIdentifier) throws EntityNotFoundRuntimeException {
        return findEntityBy(e -> e.getIdentifier().equals(anIdentifier));

    }

    /**
     * IDをキーに検索する
     *
     * @param aPredicate 判定子
     * @return 検索結果
     * @throws EntityNotFoundRuntimeException 見つからない場合に本例外を投げる
     */
    public E findEntityBy(Predicate<E> aPredicate) throws EntityNotFoundRuntimeException {
        try {
            return super.findBy(aPredicate);
        } catch (ItemNotFoundRuntimeException e) {
            throw new EntityNotFoundRuntimeException(e);
        }

    }

}
