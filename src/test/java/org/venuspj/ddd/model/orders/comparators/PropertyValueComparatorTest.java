package org.venuspj.ddd.model.orders.comparators;

import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.orders.Order;
import org.venuspj.ddd.model.orders.OrderDefinition;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

class PropertyValueComparatorTest {

    @Test
    void getProperties() {
        PropertyValueComparator<Bean1Mock> target = PropertyValueComparator.createFrom(OrderDefinition.of("property1.property2", Order.ASC));
        ArrayList<String> actual = target.getProperties();
        assertThat(actual)
                .isNotNull()
                .contains("property1", "property2");
        System.out.println(actual);


    }

    @Test
    void getOrder() {
        PropertyValueComparator<Bean1Mock> target = PropertyValueComparator.createFrom(OrderDefinition.of("property1.property2", Order.ASC));
        Order actual = target.getOrder();
        assertThat(actual)
                .isNotNull()
                .isEqualTo(Order.ASC);
        System.out.println(actual);
    }

    @Test
    void compare1() {
        PropertyValueComparator<Bean1Mock> target = PropertyValueComparator.createFrom(OrderDefinition.of("property1.property2", Order.ASC));
        int actual = target.compare(null, null);
        assertThat(actual)
                .isEqualTo(0);

    }

    @Test
    void compare2() {
        PropertyValueComparator<Bean1Mock> target = PropertyValueComparator.createFrom(OrderDefinition.of("property1", Order.ASC));
        int actual = target.compare(new Bean1Mock(1, 2), new Bean1Mock(2, 3));
        assertThat(actual)
                .isEqualTo(-1);

    }

    @Test
    void compare3() {
        PropertyValueComparator<Bean1Mock> target = PropertyValueComparator.createFrom(OrderDefinition.of("property1", Order.ASC));
        int actual = target.compare(new Bean1Mock(2, 3), new Bean1Mock(1, 2));
        assertThat(actual)
                .isEqualTo(1);

    }

    @Test
    void compare4() {
        PropertyValueComparator<Bean1Mock> target = PropertyValueComparator.createFrom(OrderDefinition.of("property2.property1", Order.ASC));
        int actual = target.compare(new Bean1Mock(1, 2), new Bean1Mock(2, 3));
        assertThat(actual)
                .isEqualTo(-1);

    }

    @Test
    void compare5() {
        PropertyValueComparator<Bean1Mock> target = PropertyValueComparator.createFrom(OrderDefinition.of("property2.property1", Order.ASC));
        int actual = target.compare(new Bean1Mock(2, 3), new Bean1Mock(1, 2));
        assertThat(actual)
                .isEqualTo(1);

    }

    @Test
    void getPropertyValue1() {
        PropertyValueComparator<Bean1Mock> target = PropertyValueComparator.createFrom(OrderDefinition.of("property1.property2", Order.ASC));
        Object actual = target.getPropertyValue(null, newArrayList("property1"));
        assertThat(actual)
                .isNull();

    }

    @Test
    void getPropertyValue2() {
        PropertyValueComparator<Bean1Mock> target = PropertyValueComparator.createFrom(OrderDefinition.of("property1.property2", Order.ASC));
        Object actual = target.getPropertyValue(new Bean1Mock(1, 2), newArrayList("property1"));
        assertThat(actual)
                .isEqualTo(1);

    }

    @Test
    void getPropertyValue3() {
        PropertyValueComparator<Bean1Mock> target = PropertyValueComparator.createFrom(OrderDefinition.of("property2.property1", Order.ASC));
        Object actual = target.getPropertyValue(new Bean1Mock(1, 2), newArrayList("property2", "property1"));
        assertThat(actual)
                .isEqualTo(2);

    }

}