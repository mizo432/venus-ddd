package org.venuspj.ddd.model.criterias.predicates;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.strings2.Strings2.EMPTY;

class ForwardMatchPredicateTest {
    @Test
    @Tag("small")
    @DisplayName("前方一致Predicateで条件にnullを設定した場合testメソッドにnullを渡した場合trueを返却する")
    public void test1() {
        // given
        ForwardMatchPredicate target = ForwardMatchPredicate.of(null);

        // when
        boolean actual = target.test(null);

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("前方一致Predicateで条件にnullを設定した場合testメソッドにemptyを渡した場合trueを返却する")
    public void test2() {
        // given
        ForwardMatchPredicate target = ForwardMatchPredicate.of(null);

        // when
        boolean actual = target.test(EMPTY);

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("前方一致Predicateで条件にnullを設定した場合testメソッドに\"1\"を渡した場合trueを返却する")
    public void test3() {
        // given
        ForwardMatchPredicate target = ForwardMatchPredicate.of(null);

        // when
        boolean actual = target.test(EMPTY);

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("前方一致Predicateで条件にnullを設定した場合testメソッドにnullを渡した場合falseを返却する")
    public void test4() {
        // given
        ForwardMatchPredicate target = ForwardMatchPredicate.of(EMPTY);

        // when
        boolean actual = target.test(null);

        // then
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    @DisplayName("前方一致Predicateで条件にEMPTYを設定した場合testメソッドにEMPTYを渡した場合trueを返却する")
    public void test5() {
        // given
        ForwardMatchPredicate target = ForwardMatchPredicate.of(EMPTY);

        // when
        boolean actual = target.test(EMPTY);

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("前方一致Predicateで条件にEMPTYを設定した場合testメソッドに\"A\"を渡した場合trueを返却する")
    public void test6() {
        // given
        ForwardMatchPredicate target = ForwardMatchPredicate.of(EMPTY);

        // when
        boolean actual = target.test("A");

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("前方一致Predicateで条件に\"A\"を設定した場合testメソッドに\"A\"を渡した場合trueを返却する")
    public void test7() {
        // given
        ForwardMatchPredicate target = ForwardMatchPredicate.of("A");

        // when
        boolean actual = target.test("A");

        // then
        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag("small")
    @DisplayName("前方一致Predicateで条件に\"A\"を設定した場合testメソッドに\"B\"を渡した場合falseを返却する")
    public void test8() {
        // given
        ForwardMatchPredicate target = ForwardMatchPredicate.of("A");

        // when
        boolean actual = target.test("B");

        // then
        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag("small")
    @DisplayName("前方一致Predicateで条件に\"A\"を設定した場合testメソッドに\"ABC\"を渡した場合trueを返却する")
    public void test9() {
        // given
        ForwardMatchPredicate target = ForwardMatchPredicate.of("A");

        // when
        boolean actual = target.test("ABC");

        // then
        assertThat(actual)
                .isTrue();

    }

}