package org.venuspj.ddd.model.values.buisiness.address;

public enum Prefecture {
    EMPTY;

    public boolean isEmpty() {
        return this == EMPTY;
    }
}
