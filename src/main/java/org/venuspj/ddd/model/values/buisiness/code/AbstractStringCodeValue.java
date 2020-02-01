package org.venuspj.ddd.model.values.buisiness.code;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

public abstract class AbstractStringCodeValue<ASC extends AbstractStringCodeValue<ASC>> extends AbstractStringValue<ASC> implements StringCodeValue<ASC> {

    public AbstractStringCodeValue(String aValue) {
        super(aValue);

    }

}
