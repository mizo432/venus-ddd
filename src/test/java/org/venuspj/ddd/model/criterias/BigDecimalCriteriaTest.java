package org.venuspj.ddd.model.criterias;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class BigDecimalCriteriaTest {

    @Test
    public void test() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setEqualTo1() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setEqualTo(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setEqualTo2() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setEqualTo(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(-1));
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void setEqualTo3() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setEqualTo(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(4));
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void setEqualTo4() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        //when
        boolean actual = target.test(null);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setNotEqualTo1() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setNotEqualTo(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void setNotEqualTo2() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setNotEqualTo(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(-1));
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setNotEqualTo3() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setNotEqualTo(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(4));
        //then
        assertThat(actual)
                .isTrue();

    }


    @Test
    public void setNull1() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setNull(Boolean.TRUE);
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isFalse();
    }

    @Test
    public void setNull2() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setNull(Boolean.TRUE);
        //when
        boolean actual = target.test(null);
        //then
        assertThat(actual)
                .isTrue();
    }

    @Test
    public void setNotNull1() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setNotNull(Boolean.TRUE);
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isTrue();
    }

    @Test
    public void setNotNull2() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setNotNull(Boolean.TRUE);
        //when
        boolean actual = target.test(null);
        //then
        assertThat(actual)
                .isFalse();
    }

    @Test
    public void setMoreThan1() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setMoreThan(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void setMoreThan2() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setMoreThan(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(-1));
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void setMoreThan3() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setMoreThan(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(4));
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setMoreThan4() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setMoreThan(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(2));
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setMoreOrEqual1() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setMoreOrEqual(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setMoreOrEqual2() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setMoreOrEqual(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(-1));
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void setMoreOrEqual3() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setMoreOrEqual(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(4));
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setMoreOrEqual4() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setMoreOrEqual(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(2));
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setLessThan1() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setLessThan(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void setLessThan2() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setLessThan(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(-1));
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setLessThan3() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setLessThan(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(4));
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void setLessThan4() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setLessThan(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ZERO);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setLessOrEqual1() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setLessOrEqual(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setLessOrEqual2() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setLessOrEqual(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(-1));
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setLessOrEqual3() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setLessOrEqual(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.valueOf(4));
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void setLessOrEqual4() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.setLessOrEqual(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ZERO);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setFrom() {
    }

    @Test
    public void setTo() {
    }

    @Test
    public void setIncludes1() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.getIncludes().add(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isTrue();

    }

    @Test
    public void setIncludes2() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.getIncludes().add(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ZERO);
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void getExcludes1() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.getExcludes().add(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ONE);
        //then
        assertThat(actual)
                .isFalse();

    }

    @Test
    public void getExcludes2() {
        //given
        BigDecimalCriteria target = new BigDecimalCriteria();
        target.getExcludes().add(BigDecimal.ONE);
        //when
        boolean actual = target.test(BigDecimal.ZERO);
        //then
        assertThat(actual)
                .isTrue();

    }
}