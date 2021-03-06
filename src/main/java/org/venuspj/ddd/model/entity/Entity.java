package org.venuspj.ddd.model.entity;

public interface Entity<E extends Entity<E, EI>, EI extends EntityIdentifier<EI>> {

    /**
     * エンティティの識別子を取得する。
     *
     * @return {@link EntityIdentifier}
     */
    EI getIdentifier();

    /**
     * エンティティの{@link #getIdentifier() 識別子}を用いて、このエンティティの同一性を比較する。
     *
     * @param that 比較対象オブジェクト
     * @return 同じ識別子を持つ場合は{@code true}
     */
    boolean equals(Object that);

    /**
     * このエンティティのハッシュコードを返す。
     * <p>Effective Java 第二版 項目9に従い、equalsメソッドを
     * オーバーライドするときは必ずhashCodeメソッドもオーバーライドする。</p>
     *
     * @return ハッシュコード
     */
    int hashCode();

    /**
     * 同じIDかを判定する
     *
     * @param other エンティティー
     * @return エンティティーとIdentifierが一致していたらtrueを返却する
     */
    boolean sameIdentifierAs(E other);

    /**
     * すべてのフィールドが一致しているかを返却する。
     *
     * @param other エンティティ
     * @return フィールドが一致していたらtrueを返却する
     */
    boolean sameValueAs(E other);

}
