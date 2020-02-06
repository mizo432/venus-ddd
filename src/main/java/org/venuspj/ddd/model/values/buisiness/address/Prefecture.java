package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;

public enum Prefecture {
    EMPTY, 北海道;

    @JsonIgnore
    public boolean isEmpty() {
        return this == EMPTY;
    }
}
