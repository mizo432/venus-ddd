package org.venuspj.ddd.model.values;

import javax.annotation.Nullable;

/**
 * 値オブジェクトインターフェイス.
 *
 * @param <V>
 */
public interface Value<V extends Value<V>> {
    /**
     * 全てのプロパティの等価性を用いて、このバリューオブジェクトの等価性を比較する。
     *
     * @param that 比較対象オブジェクト
     * @return 等価の場合は{@code true}
     */
    boolean equals(@Nullable Object that);

    /**
     * 値が自身と一致するかを確認する
     *
     * @param other 他値
     * @return 自身と一致する場合、trueを返却する
     */
    boolean sameValueAs(@Nullable V other);

}
