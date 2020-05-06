package org.venuspj.ddd.model.criterias.predicates;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BetweenPredicateTest {

    @Test
    public void of1() {
        assertThatThrownBy(() -> {
            BetweenPredicate.of(1, null);
        }).hasMessage("[EEC80001]範囲条件のfromとtoのいずれかの指定されていません。from:1, to:null");

    }

    @Test
    public void of2() {
        assertThatThrownBy(() -> {
            BetweenPredicate.of(null, 1);
        }).hasMessage("[EEC80001]範囲条件のfromとtoのいずれかの指定されていません。from:null, to:1");

    }

}