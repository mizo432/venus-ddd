package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.primitives.code.AbstractStringCodeValue;

public class AzaCode extends AbstractStringCodeValue<AzaCode> {

    public AzaCode(String aValue) {
        value = aValue;
    }

    public AzaCode() {

    }

    public static AzaCode empty() {
        return new AzaCode();


    }

    public static AzaCode of(String aValue) {
        return new AzaCode(aValue);

    }
}
