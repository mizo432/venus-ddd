package org.venuspj.ddd.model.values.primitives.code;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

public abstract class AbstractStringCodeValue<ASC extends AbstractStringCodeValue<ASC>> extends AbstractStringValue<ASC> implements StringCodeValue<ASC> {

    protected AbstractStringCodeValue(String aValue) {
        super(aValue);

    }

    protected AbstractStringCodeValue() {
        super();

    }

}
