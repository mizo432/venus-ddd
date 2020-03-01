package org.venuspj.ddd.model.values;

import static org.venuspj.util.objects2.Objects2.toStringHelper;

/**
 * 値オブジェクトの基底クラス.
 *
 * @param <VO> 値オブジェクト
 */
public abstract class AbstractValue<VO extends AbstractValue<VO>> implements Value<VO> {

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();

    }

}
