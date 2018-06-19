package org.venuspj.ddd.model.entity;

import org.venuspj.util.builder.ObjectBuilder;

import java.util.Objects;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;
import static org.venuspj.util.objects2.Objects2.nonNull;

/**
 * @param <T> エンティティクラス
 */

/**
 * エンティティの基底クラス
 *
 * @param <E>  エンティティの型
 * @param <EI> エンティティIDの型
 */
public abstract class AbstractEntity<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI, ?>> implements Entity<E, EI> {

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
    @SuppressWarnings("unchecked")
    public E clone() {
        try {
            return (E) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new Error("clone not supported");
        }
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

    public static abstract class AbstractEntityBuilder<
            E extends AbstractEntity<E, EI>,
            B extends AbstractEntityBuilder<E, B, EI>,
            EI extends EntityIdentifier<E, EI, ?>>
            extends ObjectBuilder<E, B> {

        protected EI identifier;

        @Override
        protected void apply(E vo, B builder) {
            EI entityIdentifier = vo.getIdentifier();
            builder.withEntityIdentifier(entityIdentifier);
        }

        public B withEntityIdentifier(EI identifier) {
            if (nonNull(identifier))
                addConfigurator(builder -> builder.identifier = identifier);

            return getThis();

        }

    }

}
