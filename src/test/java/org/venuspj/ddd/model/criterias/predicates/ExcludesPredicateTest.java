package org.venuspj.ddd.model.criterias.predicates;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

class ExcludesPredicateTest {

    @Test
    @Tag("small")
    public void test1() {
        //given
        BigDecimal arg = BigDecimal.ONE;
        //when
        boolean actual = ExcludesPredicate.of(newArrayList(BigDecimal.ONE)).test(arg);
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    public void test2() {
        //given
        BigDecimal arg = BigDecimal.valueOf(-1);
        //when
        boolean actual = ExcludesPredicate.of(newArrayList(BigDecimal.ONE)).test(arg);
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
        boolean actual = ExcludesPredicate.of(newArrayList(BigDecimal.ONE)).test(arg);
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
        boolean actual = ExcludesPredicate.of(newArrayList()).test(arg);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    public void test5() {
        //given
        BigDecimal arg = BigDecimal.ONE;
        //when
        boolean actual = ExcludesPredicate.of(newArrayList()).test(arg);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @SuppressWarnings("unchecked")
    public void test6() {
        //given
        BigDecimal arg = null;
        //when
        boolean actual = new ExcludesPredicate<>().test(arg);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @SuppressWarnings("unchecked")
    public void test7() {
        //given
        BigDecimal arg = BigDecimal.ONE;
        //when
        boolean actual = new ExcludesPredicate<>().test(arg);
        //then
        assertThat(actual)
                .isTrue();

    }

}
