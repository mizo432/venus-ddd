package org.venuspj.ddd.model.criterias.predicates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.strings2.Strings2.EMPTY;

class PartialMatchPredicateTest {
    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件にnullを設定した場合testメソッドにnullを渡した場合trueを返却する")
    public void test1() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of(null);

        // when
        boolean actual = target.test(null);

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件にnullを設定した場合testメソッドにemptyを渡した場合trueを返却する")
    public void test2() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of(null);

        // when
        boolean actual = target.test(EMPTY);

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件にnullを設定した場合testメソッドに\"1\"を渡した場合trueを返却する")
    public void test3() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of(null);

        // when
        boolean actual = target.test(EMPTY);

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件にnullを設定した場合testメソッドにnullを渡した場合falseを返却する")
    public void test4() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of(EMPTY);

        // when
        boolean actual = target.test(null);

        // then
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件にEMPTYを設定した場合testメソッドにEMPTYを渡した場合trueを返却する")
    public void test5() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of(EMPTY);

        // when
        boolean actual = target.test(EMPTY);

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件にEMPTYを設定した場合testメソッドに\"A\"を渡した場合trueを返却する")
    public void test6() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of(EMPTY);

        // when
        boolean actual = target.test("A");

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件に\"A\"を設定した場合testメソッドに\"A\"を渡した場合trueを返却する")
    public void test7() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of("A");

        // when
        boolean actual = target.test("A");

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件に\"A\"を設定した場合testメソッドに\"B\"を渡した場合falseを返却する")
    public void test8() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of("A");

        // when
        boolean actual = target.test("B");

        // then
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件に\"A\"を設定した場合testメソッドに\"ABC\"を渡した場合trueを返却する")
    public void test9() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of("A");

        // when
        boolean actual = target.test("ABC");

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件に\"A\"を設定した場合testメソッドに\"CAT\"を渡した場合trueを返却する")
    public void test10() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of("A");

        // when
        boolean actual = target.test("CAT");

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("部分一致Predicateで条件に\"A\"を設定した場合testメソッドに\"TEA\"を渡した場合trueを返却する")
    public void test11() {
        // given
        PartialMatchPredicate target = PartialMatchPredicate.of("A");

        // when
        boolean actual = target.test("TEA");

        // then
        assertThat(actual)
                .isTrue();

    }

}