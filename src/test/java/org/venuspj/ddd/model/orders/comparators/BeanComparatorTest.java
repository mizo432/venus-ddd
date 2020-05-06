package org.venuspj.ddd.model.orders.comparators;

import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.orders.Orders;

import static org.assertj.core.api.Assertions.assertThat;

class BeanComparatorTest {

    @Test
    void compare1() {
        BeanComparator<Bean1Mock> target = BeanComparator.createFrom(Orders.empty().addOrder("property1").addOrder("property2.property1"));
        int actual = target.compare(null, null);
        assertThat(actual)
                .isEqualTo(0);
    }

    @Test
    void compare2() {
        BeanComparator<Bean1Mock> target = BeanComparator.createFrom(Orders.empty().addOrder("property1").addOrder("property2.property1"));
        int actual = target.compare(new Bean1Mock(1, 2), new Bean1Mock(1, 2));
        assertThat(actual)
                .isEqualTo(0);
    }

    @Test
    void compare3() {
        BeanComparator<Bean1Mock> target = BeanComparator.createFrom(Orders.empty().addOrder("property1").addOrder("property2.property1"));
        int actual = target.compare(new Bean1Mock(1, 2), new Bean1Mock(1, 3));
        assertThat(actual)
                .isEqualTo(-1);
    }

    @Test
    void compare4() {
        BeanComparator<Bean1Mock> target = BeanComparator.createFrom(Orders.empty().addOrder("property1").addOrder("property2.property1"));
        int actual = target.compare(new Bean1Mock(1, 3), new Bean1Mock(1, 2));
        assertThat(actual)
                .isEqualTo(1);
    }

    @Test
    void compare5() {
        BeanComparator<Bean1Mock> target = BeanComparator.createFrom(Orders.empty().addOrder("property1").addOrder("property2.property1"));
        int actual = target.compare(new Bean1Mock(1, 2), new Bean1Mock(2, 3));
        assertThat(actual)
                .isEqualTo(-1);
    }

    @Test
    void compare6() {
        BeanComparator<Bean1Mock> target = BeanComparator.createFrom(Orders.empty().addOrder("property1").addOrder("property2.property1"));
        int actual = target.compare(new Bean1Mock(2, 3), new Bean1Mock(1, 2));
        assertThat(actual)
                .isEqualTo(1);
    }

}