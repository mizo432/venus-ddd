package org.venuspj.ddd.model.orders.comparators;

import org.venuspj.ddd.model.orders.OrderDefinition;
import org.venuspj.ddd.model.orders.Orders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static org.venuspj.util.collect.Lists2.newArrayList;

public class BeanComparator<T> implements Comparator<T> {

    private ArrayList<PropertyValueComparator<T>> propertyValueComparators = newArrayList();

    BeanComparator(Collection<PropertyValueComparator<T>> args) {
        propertyValueComparators.addAll(args);
    }

    public static <T> BeanComparator<T> createFrom(Orders anyOrders) {
        List<PropertyValueComparator<T>> args = newArrayList();
        for (OrderDefinition orderDefinition : anyOrders.getOrderDefinitions())
            args.add(PropertyValueComparator.createFrom(orderDefinition));

        return new BeanComparator<>(args);

    }

    @Override
    public int compare(T o1, T o2) {
        for (PropertyValueComparator<T> propertyValueComparator : propertyValueComparators) {
            int compared = propertyValueComparator.compare(o1, o2);
            if (compared != 0) return compared;
        }
        return 0;
    }
}
