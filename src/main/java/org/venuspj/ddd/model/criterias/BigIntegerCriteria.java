package org.venuspj.ddd.model.criterias;


import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;
import java.util.function.Predicate;

import static org.venuspj.util.collect.Lists2.newArrayList;


/**
 * BigInteger 用の検索条件.
 */
public class BigIntegerCriteria implements Serializable, Predicate<BigInteger> {

    private static final long serialVersionUID = 1L;

    private BigInteger equalTo;
    private BigInteger notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private BigInteger moreThan;
    private BigInteger moreOrEqual;
    private BigInteger lessThan;
    private BigInteger lessOrEqual;
    private BigInteger from;
    private BigInteger to;
    private List<BigInteger> includes = newArrayList();
    private List<BigInteger> excludes = newArrayList();

    public BigInteger getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(BigInteger equalTo) {
        this.equalTo = equalTo;
    }

    public BigInteger getNotEqualTo() {
        return notEqualTo;
    }

    public void setNotEqualTo(BigInteger notEqualTo) {
        this.notEqualTo = notEqualTo;
    }

    public Boolean getNull() {
        return isNull;
    }

    public void setNull(Boolean aNull) {
        isNull = aNull;
    }

    public Boolean getNotNull() {
        return isNotNull;
    }

    public void setNotNull(Boolean notNull) {
        isNotNull = notNull;
    }

    public BigInteger getMoreThan() {
        return moreThan;
    }

    public void setMoreThan(BigInteger moreThan) {
        this.moreThan = moreThan;
    }

    public BigInteger getMoreOrEqual() {
        return moreOrEqual;
    }

    public void setMoreOrEqual(BigInteger moreOrEqual) {
        this.moreOrEqual = moreOrEqual;
    }

    public BigInteger getLessThan() {
        return lessThan;
    }

    public void setLessThan(BigInteger lessThan) {
        this.lessThan = lessThan;
    }

    public BigInteger getLessOrEqual() {
        return lessOrEqual;
    }

    public void setLessOrEqual(BigInteger lessOrEqual) {
        this.lessOrEqual = lessOrEqual;
    }

    public BigInteger getFrom() {
        return from;
    }

    public void setFrom(BigInteger from) {
        this.from = from;
    }

    public BigInteger getTo() {
        return to;
    }

    public void setTo(BigInteger to) {
        this.to = to;
    }

    public List<BigInteger> getIncludes() {
        return includes;
    }

    public void setIncludes(List<BigInteger> includes) {
        this.includes = includes;
    }

    public List<BigInteger> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<BigInteger> excludes) {
        this.excludes = excludes;
    }

    @Override
    public boolean test(BigInteger aValue) {
        return EqualToPredicate.of(equalTo)
                .and(NotEqualToPredicate.of(notEqualTo))
                .and(IsNullPredicate.of(isNull))
                .and(IsNotNullPredicate.of(isNotNull))
                .and(MoreThanPredicate.of(moreThan))
                .and(MoreOrEqualPredicate.of(moreOrEqual))
                .and(LessThanPredicate.of(lessThan))
                .and(LessOrEqualPredicate.of(lessOrEqual))
                .and(IncludesPredicate.of(includes))
                .and(ExcludesPredicate.of(excludes))
                .and(BetweenPredicate.of(from, to))
                .test(aValue);
    }
}
