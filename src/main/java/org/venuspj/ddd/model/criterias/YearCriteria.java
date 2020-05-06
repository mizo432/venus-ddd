package org.venuspj.ddd.model.criterias;

import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.time.Year;
import java.util.List;
import java.util.function.Predicate;

import static org.venuspj.util.collect.Lists2.newArrayList;

/**
 * LocalDate 用の検索条件
 */
public class YearCriteria implements Serializable, Predicate<Year> {

    private static final long serialVersionUID = 1L;

    private Year equalTo;
    private Year notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private Year moreThan;
    private Year moreOrEqual;
    private Year lessThan;
    private Year lessOrEqual;
    private Year from;
    private Year to;
    private List<Year> includes = newArrayList();
    private List<Year> excludes = newArrayList();

    public Year getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(Year equalTo) {
        this.equalTo = equalTo;
    }

    public Year getNotEqualTo() {
        return notEqualTo;
    }

    public void setNotEqualTo(Year notEqualTo) {
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

    public Year getMoreThan() {
        return moreThan;
    }

    public void setMoreThan(Year moreThan) {
        this.moreThan = moreThan;
    }

    public Year getMoreOrEqual() {
        return moreOrEqual;
    }

    public void setMoreOrEqual(Year moreOrEqual) {
        this.moreOrEqual = moreOrEqual;
    }

    public Year getLessThan() {
        return lessThan;
    }

    public void setLessThan(Year lessThan) {
        this.lessThan = lessThan;
    }

    public Year getLessOrEqual() {
        return lessOrEqual;
    }

    public void setLessOrEqual(Year lessOrEqual) {
        this.lessOrEqual = lessOrEqual;
    }

    public Year getFrom() {
        return from;
    }

    public void setFrom(Year from) {
        this.from = from;
    }

    public Year getTo() {
        return to;
    }

    public void setTo(Year to) {
        this.to = to;
    }

    public List<Year> getIncludes() {
        return includes;
    }

    public void setIncludes(List<Year> includes) {
        this.includes = includes;
    }

    public List<Year> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<Year> excludes) {
        this.excludes = excludes;
    }

    @Override
    public boolean test(Year aValue) {
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
