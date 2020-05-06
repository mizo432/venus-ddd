package org.venuspj.ddd.model.orders;


import org.venuspj.ddd.model.orders.comparators.BeanComparator;
import org.venuspj.util.collect.Lists2;
import org.venuspj.util.strings2.Strings2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import static org.venuspj.util.collect.Lists2.newArrayList;


/**
 * 順番指定用クラス.
 *
 * <h2>利用方法</h2>
 * <h3>順番指定が不要な場合</h3>
 * <code>
 * Orders.empty();
 * </code>
 *
 * <h3>順番指定をする場合</h3>
 * <code>
 * Orders .empty() .addOrder("JAID"), // JAID で並びかえる(デフォルト昇順) .addOrder("JaCode", ORDER.DESC) //
 * 降順指定をするばあい .addOrder("JANAME") // JANAME で並びかえる(デフォルト昇順) ;
 * </code>
 */
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    public ArrayList<OrderDefinition> getOrderDefinitions() {
        return orderDefinitions;
    }

    private ArrayList<OrderDefinition> orderDefinitions = newArrayList();

    public Orders() {

    }

    private Orders(Collection<OrderDefinition> orderDefinitions2, OrderDefinition orderDefinition) {
        orderDefinitions.addAll(orderDefinitions2);
        orderDefinitions.add(orderDefinition);

    }

    public static Orders empty() {
        return new Orders();

    }

    public boolean isEmpty() {
        return orderDefinitions.isEmpty();

    }

    public Orders addOrder(String propertyName) {
        return new Orders(orderDefinitions, OrderDefinition.of(propertyName));

    }

    public Orders addOrder(String propertyName, Order order) {
        return new Orders(orderDefinitions, OrderDefinition.of(propertyName, order));
    }

    public int size() {

        return orderDefinitions.size();
    }

    public String getText() {
        return Strings2.join(", " + System.lineSeparator(),
                Lists2.transform(orderDefinitions, OrderDefinition::getText));

    }

    public String getOrderByText() {
        return isNotEmpty() ? "order by " + getText() : "";

    }

    private boolean isNotEmpty() {
        return !isEmpty();

    }

    public <T> Comparator<T> toComparator() {
        return BeanComparator.createFrom(this);

    }

}
