package org.venuspj.ddd.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.venuspj.ddd.model.values.Value;

import static org.venuspj.util.objects2.Objects2.*;

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
    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
    public EI getIdentifier() {
        return identifier;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
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

    @JsonIgnore
    public boolean isEmpty() {
        return identifier.isEmpty()
                && entityInfo.isEmpty();

    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();
    }
}
