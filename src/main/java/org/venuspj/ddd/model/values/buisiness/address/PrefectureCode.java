package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.primitives.code.AbstractStringCodeValue;

public class PrefectureCode extends AbstractStringCodeValue<PrefectureCode> {
    public PrefectureCode(String aValue) {
        value = aValue;
    }

    public PrefectureCode() {

    }

    public static PrefectureCode empty() {
        return new PrefectureCode();


    }

    public static PrefectureCode of(String aValue) {
        return new PrefectureCode(aValue);

    }
}
