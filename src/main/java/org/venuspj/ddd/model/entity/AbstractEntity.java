package org.venuspj.ddd.model.entity;

import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * エンティティの抽象クラス
 *
 * @param <T> エンティティクラス
 */
public abstract class AbstractEntity<T extends Entity<T>> implements Entity<T> {

    private EntityIdentifier<T> identifier;

    protected AbstractEntity() {

    }

    protected AbstractEntity(EntityIdentifier<T> identifier) {
        this.identifier = identifier;
    }

    @Override
    public EntityIdentifier<T> getIdentifier() {
        return identifier;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T clone() {
        try {
            return (T) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("clone not supported");
        }
    }

    @Override
    public int hashCode() {
        if(isNull(identifier)) return 0;
        return identifier.hashCode();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object that) {
        return that instanceof AbstractEntity
                && identifier.sameValueAs(((AbstractEntity) that).identifier);
    }

    /**
     * @param other
     * @return
     */
    @Override
    public boolean sameIdentifierAs(T other) {
        return equals(other);
    }

}
