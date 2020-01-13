package org.venuspj.ddd.model.values.primitives;


import org.venuspj.ddd.model.values.Value;

public interface SingleValue<T, SV extends SingleValue<T, SV>> extends Value<SV> {
    /**
     * 内部保持値を取得する。
     *
     * @return 内部保持値
     */
    T getValue();


    /**
     * このエンティティのハッシュコードを返す。
     *
     * @return ハッシュコード
     */
    int hashCode();


}
