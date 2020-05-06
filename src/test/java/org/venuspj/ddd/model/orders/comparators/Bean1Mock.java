package org.venuspj.ddd.model.orders.comparators;

public class Bean1Mock {
    private final int property1;
    private final Bean1Mock property2;

    public int getProperty1() {
        return property1;
    }

    public Bean1Mock getProperty2() {
        return property2;
    }

    public Bean1Mock(int value1, int value2) {
        property1 = value1;
        property2 = new Bean1Mock(value2);

    }

    public Bean1Mock(int value) {
        property1 = value;
        property2 = null;
    }
}
