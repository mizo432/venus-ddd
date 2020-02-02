package org.venuspj.ddd.model.values.buisiness.amount;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.quantity.Quantity;
import org.venuspj.ddd.model.values.buisiness.rate.Rate;
import org.venuspj.tests.constants.TestSize;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class AmountTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        Amount target = Amount.empty();
        System.out.println(target.asText());
        assertThat(target.asText())
                .isNull();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void zeroYen() {
        Amount target = Amount.zeroYen();
        System.out.println(target.asText());
        assertThat(target.asText())
                .isEqualTo("￥0");
    }

    @Test
    @Tag(TestSize.SMALL)
    public void valueOf() {
        Amount target = Amount.yen(1000L);
        System.out.println(target.asText());
        assertThat(target.asText())
                .isEqualTo("￥1,000");
    }

    @Test
    @Tag(TestSize.SMALL)
    public void sum1() {
        Amount target = Amount.sum(Amount.yen(1000L), Amount.yen(3000L));
        System.out.println(target.asText());
        assertThat(target.asText())
                .isEqualTo("￥4,000");
    }

    @Test
    @Tag(TestSize.SMALL)
    public void sum2() {
        ArrayList<Amount> amounts = newArrayList(Amount.yen(10L), Amount.yen(20L));
        Amount target = Amount.sum(amounts);
        System.out.println(target.asText());
        assertThat(target.asText())
                .isEqualTo("￥30");

    }

    @Test
    @Tag(TestSize.SMALL)
    public void multiply1() {
        //given
        Quantity quantity = Quantity.of(BigDecimal.valueOf(3));

        //when
        Amount target = Amount.yen(4000L);

        //then
        assertThat(target.multiply(quantity))
                .isEqualTo(Amount.yen(12000L));
    }

    @Test
    @Tag(TestSize.SMALL)
    public void multiply2() {
        //given
        Rate rate = Rate.valueOf(BigDecimal.valueOf(0.08));
        Amount target = Amount.yen(1000L);

        //when
        Amount actual = target.multiply(rate);

        //then
        assertThat(actual)
                .isEqualTo(Amount.yen(80L));
    }

}
