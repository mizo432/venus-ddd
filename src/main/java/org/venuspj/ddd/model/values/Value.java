package org.venuspj.ddd.model.values;

/**
 * 値オブジェクトインターフェイス.
 *
 * @param <V>
 */

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("value")
public interface Value<V extends Value<V>> {
    /**
     * 全てのプロパティの等価性を用いて、このバリューオブジェクトの等価性を比較する。
     *
     * @param that 比較対象オブジェクト
     * @return 等価の場合は{@code true}
     */
    boolean equals(Object that);

    /**
     * 値が自身と一致するかを確認する
     *
     * @param other 他値
     * @return 自身と一致する場合、trueを返却する
     */
    boolean sameValueAs(V other);

    boolean isEmpty();

}
