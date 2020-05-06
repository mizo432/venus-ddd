package org.venuspj.ddd.model.criterias;


import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Predicate;

import static org.venuspj.util.collect.Lists2.newArrayList;

/**
 * Integer 用の検索条件
 */
public class IntegerCriteria implements Serializable, Predicate<Integer> {

    private static final long serialVersionUID = 1L;

    private Integer moreThan;
    private Integer moreOrEqual;
    private Integer lessThan;
    private Integer lessOrEqual;
    private Integer from;
    private Integer to;
    private Integer equalTo;
    private Integer notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private ArrayList<Integer> includes = newArrayList();
    private ArrayList<Integer> excludes = newArrayList();

    public Integer getNotEqualTo() {
        return notEqualTo;
    }

    public Boolean getNull() {
        return isNull;
    }

    public Boolean getNotNull() {
        return isNotNull;
    }

    public ArrayList<Integer> getIncludes() {
        return includes;
    }

    public ArrayList<Integer> getExcludes() {
        return excludes;
    }

    public Integer getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(Integer equalTo) {
        this.equalTo = equalTo;
    }

    public void setNotEqualTo(Integer notEqualTo) {
        this.notEqualTo = notEqualTo;
    }

    public void setNull(Boolean aNull) {
        isNull = aNull;
    }

    public void setNotNull(Boolean notNull) {
        isNotNull = notNull;
    }

    public Integer getMoreThan() {
        return moreThan;
    }

    public void setMoreThan(Integer moreThan) {
        this.moreThan = moreThan;
    }

    public Integer getMoreOrEqual() {
        return moreOrEqual;
    }

    public void setMoreOrEqual(Integer moreOrEqual) {
        this.moreOrEqual = moreOrEqual;
    }

    public Integer getLessThan() {
        return lessThan;
    }

    public void setLessThan(Integer lessThan) {
        this.lessThan = lessThan;
    }

    public Integer getLessOrEqual() {
        return lessOrEqual;
    }

    public void setLessOrEqual(Integer lessOrEqual) {
        this.lessOrEqual = lessOrEqual;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    @Override
    public boolean test(Integer aValue) {
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
