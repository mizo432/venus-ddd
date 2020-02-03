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
public abstract class AbstractEntity<E extends AbstractEntity<E, EI>, EI extends EntityIdentifier<E, EI>> implements Entity<E, EI>, Value<E> {

    private EI identifier;

    protected AbstractEntity() {

    }

    protected AbstractEntity(EI identifier) {
        this.identifier = identifier;
    }

    @Override
    public EI getIdentifier() {
        return identifier;
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

}
