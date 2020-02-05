package org.venuspj.ddd.model.forTest.model.concrete.entities;

import org.venuspj.ddd.model.values.Value;

public class ConcreteInfo implements Value<ConcreteInfo> {

    public static ConcreteInfo empty() {
        return new ConcreteInfo();

    }

    @Override
    public boolean sameValueAs(ConcreteInfo other) {
        return true;

    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
