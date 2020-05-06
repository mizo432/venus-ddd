package org.venuspj.ddd.model.criterias;


import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.function.Predicate;

import static org.venuspj.util.collect.Lists2.newArrayList;


/**
 * BigDecimal 用の検索条件
 */
public class BigDecimalCriteria implements Serializable, Predicate<BigDecimal> {

    private BigDecimal moreThan;
    private BigDecimal moreOrEqual;
    private BigDecimal lessThan;
    private BigDecimal lessOrEqual;
    private BigDecimal from;
    private BigDecimal to;
    private BigDecimal equalTo;
    private BigDecimal notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private ArrayList<BigDecimal> includes = newArrayList();
    private ArrayList<BigDecimal> excludes = newArrayList();

    public BigDecimal getNotEqualTo() {
        return notEqualTo;
    }

    public Boolean getNull() {
        return isNull;
    }

    public Boolean getNotNull() {
        return isNotNull;
    }

    public ArrayList<BigDecimal> getIncludes() {
        return includes;
    }

    public ArrayList<BigDecimal> getExcludes() {
        return excludes;
    }

    public BigDecimal getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(BigDecimal equalTo) {
        this.equalTo = equalTo;
    }

    public void setNotEqualTo(BigDecimal notEqualTo) {
        this.notEqualTo = notEqualTo;
    }

    public void setNull(Boolean aNull) {
        isNull = aNull;
    }

    public void setNotNull(Boolean notNull) {
        isNotNull = notNull;
    }


    public BigDecimal getMoreThan() {
        return moreThan;
    }

    public void setMoreThan(BigDecimal moreThan) {
        this.moreThan = moreThan;
    }

    public BigDecimal getMoreOrEqual() {
        return moreOrEqual;
    }

    public void setMoreOrEqual(BigDecimal moreOrEqual) {
        this.moreOrEqual = moreOrEqual;
    }

    public BigDecimal getLessThan() {
        return lessThan;
    }

    public void setLessThan(BigDecimal lessThan) {
        this.lessThan = lessThan;
    }

    public BigDecimal getLessOrEqual() {
        return lessOrEqual;
    }

    public void setLessOrEqual(BigDecimal lessOrEqual) {
        this.lessOrEqual = lessOrEqual;
    }

    public BigDecimal getFrom() {
        return from;
    }

    public void setFrom(BigDecimal from) {
        this.from = from;
    }

    public BigDecimal getTo() {
        return to;
    }

    public void setTo(BigDecimal to) {
        this.to = to;
    }

    @Override
    public boolean test(BigDecimal aValue) {
        return EqualToPredicate.of(equalTo)
                .and(NotEqualToPredicate.of(notEqualTo))
                .and(IsNullPredicate.of(isNull))
                .and(IsNotNullPredicate.of(isNotNull))
                .and(IncludesPredicate.of(includes))
                .and(ExcludesPredicate.of(excludes))
                .and(MoreThanPredicate.of(moreThan))
                .and(MoreOrEqualPredicate.of(moreOrEqual))
                .and(LessThanPredicate.of(lessThan))
                .and(LessOrEqualPredicate.of(lessOrEqual))
                .and(BetweenPredicate.of(from, to))
                .test(aValue);

    }
}
