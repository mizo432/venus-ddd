package org.venuspj.ddd.model.criterias;

import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Predicate;

import static org.venuspj.util.collect.Lists2.newArrayList;

/**
 * Long 用の検索条件
 */
public class LongCriteria implements Serializable, Predicate<Long> {

    private static final long serialVersionUID = 1L;

    private Long moreThan;
    private Long moreOrEqual;
    private Long lessThan;
    private Long lessOrEqual;
    private Long from;
    private Long to;
    private Long equalTo;
    private Long notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private ArrayList<Long> includes = newArrayList();
    private ArrayList<Long> excludes = newArrayList();

    public Long getNotEqualTo() {
        return notEqualTo;
    }

    public Boolean getNull() {
        return isNull;
    }

    public Boolean getNotNull() {
        return isNotNull;
    }

    public ArrayList<Long> getIncludes() {
        return includes;
    }

    public ArrayList<Long> getExcludes() {
        return excludes;
    }

    public Long getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(Long equalTo) {
        this.equalTo = equalTo;
    }

    public void setNotEqualTo(Long notEqualTo) {
        this.notEqualTo = notEqualTo;
    }

    public void setNull(Boolean aNull) {
        isNull = aNull;
    }

    public void setNotNull(Boolean notNull) {
        isNotNull = notNull;
    }

    public Long getMoreThan() {
        return moreThan;
    }

    public void setMoreThan(Long moreThan) {
        this.moreThan = moreThan;
    }

    public Long getMoreOrEqual() {
        return moreOrEqual;
    }

    public void setMoreOrEqual(Long moreOrEqual) {
        this.moreOrEqual = moreOrEqual;
    }

    public Long getLessThan() {
        return lessThan;
    }

    public void setLessThan(Long lessThan) {
        this.lessThan = lessThan;
    }

    public Long getLessOrEqual() {
        return lessOrEqual;
    }

    public void setLessOrEqual(Long lessOrEqual) {
        this.lessOrEqual = lessOrEqual;
    }

    public Long getFrom() {
        return from;
    }

    public void setFrom(Long from) {
        this.from = from;
    }

    public Long getTo() {
        return to;
    }

    public void setTo(Long to) {
        this.to = to;
    }


    @Override
    public boolean test(Long aValue) {
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
