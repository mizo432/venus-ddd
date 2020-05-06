package org.venuspj.ddd.model.orders;

import java.io.Serializable;

public class OrderDefinition implements Serializable {

    private String propertyName;
    private Order order;

    private OrderDefinition() {

        this.propertyName = "";
        this.order = Order.UNDEFINED;
    }

    private OrderDefinition(String propertyName, Order order) {

        this.propertyName = propertyName;
        this.order = order;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Order getOrder() {
        return order;
    }

    public static OrderDefinition of(String propertyName) {
        return new OrderDefinition(propertyName, Order.ASC);

    }

    public static OrderDefinition of(String propertyName, Order order) {
        return new OrderDefinition(propertyName, order);

    }

    public String getText() {

        if (order.isDescending()) {
            return propertyName + " " + order.name();
        }

        return propertyName;
    }


}
