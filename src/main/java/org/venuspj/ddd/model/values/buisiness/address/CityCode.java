package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.primitives.code.AbstractStringCodeValue;

/**
 * 市区郡町村コード
 */
public class CityCode extends AbstractStringCodeValue<CityCode> {

    public CityCode(String aValue) {
        super(aValue);

    }

    public CityCode() {

    }

    public static CityCode of(String aValue) {
        return new CityCode(aValue);

    }

    public static CityCode empty() {
        return new CityCode();
    }
}
