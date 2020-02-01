package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class IsEqualToCriteriaTest {

    @DisplayName("一致している場合の確認")
    @Tag(TestSize.SMALL)
    @Test
    public void test1() {
        Integer arg = 1;
        IsEqualToCriteria<Integer> target = new IsEqualToCriteria<>();

        target.setValue(arg);

        boolean actual = target.test(1);

        assertThat(actual)
                .isTrue();


    }

    @DisplayName("少ない場合の確認")
    @Tag(TestSize.SMALL)
    @Test
    public void test2() {
        Integer arg = 1;
        IsEqualToCriteria<Integer> target = new IsEqualToCriteria<>();

        target.setValue(arg);

        boolean actual = target.test(0);

        assertThat(actual)
                .isFalse();


    }

    @DisplayName("多い場合の確認")
    @Tag(TestSize.SMALL)
    @Test
    public void test3() {
        Integer arg = 1;
        IsEqualToCriteria<Integer> target = new IsEqualToCriteria<>();

        target.setValue(arg);

        boolean actual = target.test(2);

        assertThat(actual)
                .isFalse();


    }

}
