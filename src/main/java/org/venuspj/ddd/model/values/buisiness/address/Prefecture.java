package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;

public enum Prefecture {
    EMPTY;

    @JsonIgnore
    public boolean isEmpty() {
        return this == EMPTY;
    }
}
