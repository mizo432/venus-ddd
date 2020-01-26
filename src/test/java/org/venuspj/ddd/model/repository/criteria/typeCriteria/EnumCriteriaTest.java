package org.venuspj.ddd.model.repository.criteria.typeCriteria;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class EnumCriteriaTest {

    @Test
    public void getIsEqualCriteria1() {
        EnumCriteria<DummyEnum> targetCriteria = new EnumCriteria<>();
        targetCriteria.getIsEqualCriteria().setValue(DummyEnum.ELEMENT1);

        assertThat(targetCriteria.test(DummyEnum.ELEMENT1))
                .isTrue();
    }

    @Test
    public void getIsEqualCriteria2() {
        EnumCriteria<DummyEnum> targetCriteria = new EnumCriteria<>();
        targetCriteria.getIsEqualCriteria().setValue(DummyEnum.ELEMENT1);

        assertThat(targetCriteria.test(DummyEnum.ELEMENT2))
                .isFalse();
    }

    @Test
    public void getIncludeCriteria1() {
        EnumCriteria<DummyEnum> targetCriteria = new EnumCriteria<>();
        targetCriteria.getIncludeCriteria().setValue(newArrayList(DummyEnum.ELEMENT1));

        assertThat(targetCriteria.test(DummyEnum.ELEMENT1))
                .isTrue();
    }

    @Test
    public void getIncludeCriteria2() {
        EnumCriteria<DummyEnum> targetCriteria = new EnumCriteria<>();
        targetCriteria.getIncludeCriteria().setValue(newArrayList(DummyEnum.ELEMENT1));

        assertThat(targetCriteria.test(DummyEnum.ELEMENT2))
                .isFalse();
    }
}
