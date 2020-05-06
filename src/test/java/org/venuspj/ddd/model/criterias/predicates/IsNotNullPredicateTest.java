package org.venuspj.ddd.model.criterias.predicates;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class IsNotNullPredicateTest {
    @Test
    @Tag("small")
    public void test1() {
        //given
        BigDecimal arg = BigDecimal.ONE;
        //when
        boolean actual = IsNotNullPredicate.of(null).test(arg);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void test2() {
        //given
        BigDecimal arg = BigDecimal.valueOf(-1);
        //when
        boolean actual = IsNotNullPredicate.of(Boolean.TRUE).test(arg);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void test3() {
        //given
        BigDecimal arg = BigDecimal.valueOf(4);
        //when
        boolean actual = IsNotNullPredicate.of(Boolean.FALSE).test(arg);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void test4() {
        //given
        BigDecimal arg = null;
        //when
        boolean actual = IsNotNullPredicate.of(Boolean.FALSE).test(arg);
        //then
        assertThat(actual)
                .isTrue();

    }
}