package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.SingleValue;

import java.time.Year;

/**
 * 年を示すバリユーオブジェクト
 * Created by mizoguchi on 2017/02/12.
 */
public interface YearValue<T extends YearValue<T>> extends SingleValue<Year, T> {

    Year asYear();

    Year getValue();

    String asText();
}
