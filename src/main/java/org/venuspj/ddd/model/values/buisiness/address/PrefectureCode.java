package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.primitives.code.AbstractStringCodeValue;

public class PrefectureCode extends AbstractStringCodeValue<PrefectureCode> {
    public static PrefectureCode empty() {
        return new PrefectureCode();

    }
}
