package org.venuspj.ddd.model.repository.criteria.typeCriteria;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.test.consts.TestSize;

import static org.assertj.core.api.Assertions.assertThat;
import static org.venuspj.util.collect.Lists2.newArrayList;

public class EnumCriteriaTest {

    @Test
    @Tag(TestSize.SMALL)
    public void getIsEqualCriteria1() {
        EnumCriteria<DummyEnum> targetCriteria = new EnumCriteria<>();
        targetCriteria.getIsEqualCriteria().setValue(DummyEnum.ELEMENT1);

        assertThat(targetCriteria.test(DummyEnum.ELEMENT1))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void getIsEqualCriteria2() {
        EnumCriteria<DummyEnum> targetCriteria = new EnumCriteria<>();
        targetCriteria.getIsEqualCriteria().setValue(DummyEnum.ELEMENT1);

        assertThat(targetCriteria.test(DummyEnum.ELEMENT2))
                .isFalse();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void getIncludeCriteria1() {
        EnumCriteria<DummyEnum> targetCriteria = new EnumCriteria<>();
        targetCriteria.getIncludeCriteria().setValue(newArrayList(DummyEnum.ELEMENT1));

        assertThat(targetCriteria.test(DummyEnum.ELEMENT1))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void getIncludeCriteria2() {
        EnumCriteria<DummyEnum> targetCriteria = new EnumCriteria<>();
        targetCriteria.getIncludeCriteria().setValue(newArrayList(DummyEnum.ELEMENT1));

        assertThat(targetCriteria.test(DummyEnum.ELEMENT2))
                .isFalse();
    }
}
