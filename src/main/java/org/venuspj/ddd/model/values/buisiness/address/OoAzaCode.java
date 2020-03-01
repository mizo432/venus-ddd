package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.primitives.code.AbstractStringCodeValue;

public class OoAzaCode extends AbstractStringCodeValue<OoAzaCode> {

    public OoAzaCode(String aValue) {
        value = aValue;
    }

    public OoAzaCode() {

    }

    public static OoAzaCode empty() {
        return new OoAzaCode();


    }

    public static OoAzaCode of(String aValue) {
        return new OoAzaCode(aValue);

    }
}
