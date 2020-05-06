package org.venuspj.ddd.model.values.buisiness.amount;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.Percentage;
import org.venuspj.ddd.model.values.buisiness.money.Amount;
import org.venuspj.ddd.model.values.buisiness.quantity.QuantityDecimal;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class AmountTest {

    @Test
    @Tag("small")
    public void empty() {
        Amount target = Amount.empty();
        System.out.println(target.asText());
        assertThat(target.asText())
                .isNull();
    }

    @Test
    @Tag("small")
    public void zeroYen() {
        Amount target = Amount.zeroYen();
        System.out.println(target.asText());
        assertThat(target.asText())
                .isEqualTo("￥0");
    }

    @Test
    @Tag("small")
    public void valueOf() {
        Amount target = Amount.yen(1000L);
        System.out.println(target.asText());
        assertThat(target.asText())
                .isEqualTo("￥1,000");
    }

    @Test
    @Tag("small")
    public void sum1() {
        Amount target = Amount.sum(Amount.yen(1000L), Amount.yen(3000L));
        System.out.println(target.asText());
        assertThat(target.asText())
                .isEqualTo("￥4,000");
    }

    @Test
    @Tag("small")
    public void sum2() {
        ArrayList<Amount> amounts = newArrayList(Amount.yen(10L), Amount.yen(20L));
        Amount target = Amount.sum(amounts);
        System.out.println(target.asText());
        assertThat(target.asText())
                .isEqualTo("￥30");

    }

    @Test
    @Tag("small")
    public void multiply1() {
        //given
        QuantityDecimal quantityDecimal = QuantityDecimal.of(BigDecimal.valueOf(3));

        //when
        Amount target = Amount.yen(4000L);

        //then
        assertThat(target.multiply(quantityDecimal))
                .isEqualTo(Amount.yen(12000L));
    }

    @Test
    @Tag("small")
    public void multiply2() {
        //given
        Percentage percentage = Percentage.valueOf(BigDecimal.valueOf(8));
        Amount target = Amount.yen(1000L);

        //when
        Amount actual = target.multiply(percentage);

        //then
        assertThat(actual)
                .isEqualTo(Amount.yen(80L));
    }

    @Test
    @Tag("small")
    public void compareTo() {
        assertThat(Amount.yen(500L).compareTo(Amount.zeroYen()))
                .isEqualTo(1);

    }
}
