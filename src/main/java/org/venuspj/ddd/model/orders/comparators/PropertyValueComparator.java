package org.venuspj.ddd.model.orders.comparators;

import org.venuspj.ddd.model.orders.Order;
import org.venuspj.ddd.model.orders.OrderDefinition;
import org.venuspj.util.beans.BeanDesc;
import org.venuspj.util.beans.PropertyDesc;
import org.venuspj.util.beans.factory.BeanDescFactory;
import org.venuspj.util.collect.ComparisonChain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.venuspj.util.collect.Lists2.newArrayList;
import static org.venuspj.util.objects2.Objects2.isNull;
import static org.venuspj.util.strings2.Strings2.split;

public class PropertyValueComparator<T> implements Comparator<T> {
    private final ArrayList<String> properties = newArrayList();
    private final Order order;

    ArrayList<String> getProperties() {
        return properties;
    }

    Order getOrder() {
        return order;
    }

    PropertyValueComparator(ArrayList<String> anyProperties, Order anOrder) {
        properties.addAll(anyProperties);
        order = anOrder;

    }

    public static <T> PropertyValueComparator<T> createFrom(OrderDefinition anOrderDefinition) {
        return new PropertyValueComparator<>(
                newArrayList(split(anOrderDefinition.getPropertyName(), '.')),
                anOrderDefinition.getOrder());

    }

    @Override
    public int compare(T o1, T o2) {
        if (o1 == o2) return 0;
        Comparable<?> value1 = getPropertyValue(o1, properties);
        Comparable<?> value2 = getPropertyValue(o2, properties);
        int coefficient = order.isDescending() ? -1 : 1;
        return ComparisonChain.start().compare(value1, value2).result() * coefficient;
    }

    Comparable<?> getPropertyValue(T object, List<String> propertyNameStack) {
        Object value = object;
        for (String propertyName : propertyNameStack) {
            if (isNull(value)) return null;
            BeanDesc bd = BeanDescFactory.getBeanDesc(value.getClass());
            PropertyDesc pd = bd.getPropertyDesc(propertyName);
            value = pd.getValue(value);

        }
        return (Comparable<?>) value;

    }

}
