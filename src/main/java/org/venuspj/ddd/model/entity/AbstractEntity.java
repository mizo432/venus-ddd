package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.values.Value;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * @param <T> エンティティクラス
 */

/**
 * エンティティの基底クラス
 *
 * @param <E>  エンティティの型
 * @param <EI> エンティティIDの型
 */
public abstract class AbstractEntity<E extends AbstractEntity<E, EI, V>, EI extends EntityIdentifier<E, EI>, V extends Value<V>> implements Entity<E, EI>, Value<E> {

    private EI identifier;
    private V entityInfo;

    protected AbstractEntity() {

    }

    protected AbstractEntity(EI anIdentifier, V anEntityInfo) {

        this.identifier = anIdentifier;
        entityInfo = anEntityInfo;
    }

    @Override
    public EI getIdentifier() {
        return identifier;
    }

    protected V getEntityInfo() {
        return entityInfo;
    }

    @Override
    public int hashCode() {
        if (isNull(identifier)) return 0;
        return identifier.hashCode();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object that) {
        return that instanceof AbstractEntity
                && sameIdentifierAs((E) that);

    }

    /**
     * @param other
     * @return
     */
    @Override
    public boolean sameIdentifierAs(E other) {
        return equal(identifier, other.getIdentifier());

    }

    @Override
    public boolean sameValueAs(E other) {
        return sameIdentifierAs(other)
                && entityInfo.sameValueAs(other.getEntityInfo());

    }

    public boolean isEmpty() {
        return identifier.isEmpty()
                && entityInfo.isEmpty();

    }
}
