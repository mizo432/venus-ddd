package org.venuspj.ddd.model.value;

public interface Value<T extends Value<T>> {

    /**
     * 全てのプロパティの等価性を用いて、このバリューオブジェクトの等価性を比較する。
     *
     * @param that 比較対象オブジェクト
     * @return 等価の場合は{@code true}
     */
    boolean equals(Object that);

    /**
     * このエンティティのハッシュコードを返す。
     *
     * @return ハッシュコード
     */
    int hashCode();

    /**
     * 値が自身と一致するかを確認する
     *
     * @param other 他値
     * @return 自身と一致する場合、trueを返却する
     */
    boolean sameValueAs(T other);

    T getValue();

}
