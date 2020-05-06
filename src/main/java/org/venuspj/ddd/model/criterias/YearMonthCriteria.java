package org.venuspj.ddd.model.criterias;


import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.time.YearMonth;
import java.util.List;
import java.util.function.Predicate;

import static org.venuspj.util.collect.Lists2.newArrayList;


/**
 * LocalDate 用の検索条件
 */
public class YearMonthCriteria implements Serializable, Predicate<YearMonth> {

    private static final long serialVersionUID = 1L;

    private YearMonth equalTo;
    private YearMonth notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private YearMonth moreThan;
    private YearMonth moreOrEqual;
    private YearMonth lessThan;
    private YearMonth lessOrEqual;
    private YearMonth from;
    private YearMonth to;
    private List<YearMonth> includes = newArrayList();
    private List<YearMonth> excludes = newArrayList();

    public YearMonth getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(YearMonth equalTo) {
        this.equalTo = equalTo;
    }

    public YearMonth getNotEqualTo() {
        return notEqualTo;
    }

    public void setNotEqualTo(YearMonth notEqualTo) {
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

    public YearMonth getMoreThan() {
        return moreThan;
    }

    public void setMoreThan(YearMonth moreThan) {
        this.moreThan = moreThan;
    }

    public YearMonth getMoreOrEqual() {
        return moreOrEqual;
    }

    public void setMoreOrEqual(YearMonth moreOrEqual) {
        this.moreOrEqual = moreOrEqual;
    }

    public YearMonth getLessThan() {
        return lessThan;
    }

    public void setLessThan(YearMonth lessThan) {
        this.lessThan = lessThan;
    }

    public YearMonth getLessOrEqual() {
        return lessOrEqual;
    }

    public void setLessOrEqual(YearMonth lessOrEqual) {
        this.lessOrEqual = lessOrEqual;
    }

    public YearMonth getFrom() {
        return from;
    }

    public void setFrom(YearMonth from) {
        this.from = from;
    }

    public YearMonth getTo() {
        return to;
    }

    public void setTo(YearMonth to) {
        this.to = to;
    }

    public List<YearMonth> getIncludes() {
        return includes;
    }

    public void setIncludes(List<YearMonth> includes) {
        this.includes = includes;
    }

    public List<YearMonth> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<YearMonth> excludes) {
        this.excludes = excludes;
    }

    @Override
    public boolean test(YearMonth aValue) {
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
