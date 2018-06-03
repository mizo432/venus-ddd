package org.venuspj.ddd.model.repository;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortCondition<T> implements Serializable, Iterable<SortCondition.Order>, Comparator<T> {

    SortCondition(List<Order> orders){

    }
    SortCondition(Direction direction, List<String> properties){

    }
    SortCondition(Direction direction, String... properties){

    }
    SortCondition(Order... orders){

    }

    SortCondition and(SortCondition sort){

        return sort;
    }

    @Override
    public int compare(T o1, T o2) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * Returns the order registered for the given property.
     * @param property
     * @return
     */
    Order	getOrderFor(String property){
        return null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public Iterator<Order> iterator() {
        return null;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static class Order{

    }

    public static class NullHandling{

    }

    public static class Direction{

    }

}
