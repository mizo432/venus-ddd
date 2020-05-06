package org.venuspj.ddd.model.orders;

public enum Order {
    ASC, DESC, UNDEFINED;

    public boolean isDescending() {

        return this == DESC;
    }
    
}
