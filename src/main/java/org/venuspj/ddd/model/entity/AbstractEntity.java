package org.venuspj.ddd.model.entity;

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
public abstract class AbstractEntity
        <E extends AbstractEntity<E, EI>,
                EI extends EntityIdentifier<EI>>
        implements
        Entity<E, EI>, Value<E>, Comparable<E> {

    private EI identifier;

    /**
     * コンストラクター.
     *
     * @param anIdentifier ID
     */
    protected AbstractEntity(EI anIdentifier) {

        this.identifier = anIdentifier;
    }

    @Override
    public EI getIdentifier() {
        return identifier;
    }

    /**
     * IDを使用しhash値を作成する
     *
     * @return ハッシュ値
     */
    @Override
    public int hashCode() {
        if (isNull(identifier)) return 0;
        return identifier.hashCode();
    }

    /**
     * エンティティの{@link #getIdentifier() 識別子}を用いて、このエンティティの同一性を比較する。
     *
     * @param that 比較対象オブジェクト
     * @return 一致していたらtrueを返却する
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object that) {
        return that instanceof AbstractEntity<?, ?>
                && sameIdentifierAs((E) that);

    }

    /**
     * 同じIDかを判定する
     *
     * @param other エンティティ
     * @return エンティティとIdentifierが一致していたらtrueを返却する
     */
    @Override
    public boolean sameIdentifierAs(E other) {
        return nonNull(other)
                && equal(identifier, other.getIdentifier());

    }

    /**
     * すべてのフィールドが一致しているかを返却する。
     *
     * @param other エンティティ
     * @return フィールドが一致していたらtrueを返却する
     */
    @Override
    public boolean sameValueAs(E other) {
        return sameIdentifierAs(other);

    }

    public boolean isEmpty() {
        return identifier.isEmpty();

    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();
    }

    @Override
    public int compareTo(E o) {
        if (isNull(o)) return -1;
        return identifier.compareTo(o.getIdentifier());
    }
}
