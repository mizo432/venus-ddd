package org.venuspj.ddd.model.criterias;

import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import static org.venuspj.util.collect.Lists2.newArrayList;

/**
 * LocalDate 用の検索条件
 */
public class LocalDateCriteria implements Serializable, Predicate<LocalDate> {

    private static final long serialVersionUID = 1L;

    private LocalDate equalTo;
    private LocalDate notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private LocalDate moreThan;
    private LocalDate moreOrEqual;
    private LocalDate lessThan;
    private LocalDate lessOrEqual;
    private LocalDate from;
    private LocalDate to;
    private List<LocalDate> includes = newArrayList();
    private List<LocalDate> excludes = newArrayList();

    public LocalDate getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(LocalDate equalTo) {
        this.equalTo = equalTo;
    }

    public LocalDate getNotEqualTo() {
        return notEqualTo;
    }

    public void setNotEqualTo(LocalDate notEqualTo) {
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

    public LocalDate getMoreThan() {
        return moreThan;
    }

    public void setMoreThan(LocalDate moreThan) {
        this.moreThan = moreThan;
    }

    public LocalDate getMoreOrEqual() {
        return moreOrEqual;
    }

    public void setMoreOrEqual(LocalDate moreOrEqual) {
        this.moreOrEqual = moreOrEqual;
    }

    public LocalDate getLessThan() {
        return lessThan;
    }

    public void setLessThan(LocalDate lessThan) {
        this.lessThan = lessThan;
    }

    public LocalDate getLessOrEqual() {
        return lessOrEqual;
    }

    public void setLessOrEqual(LocalDate lessOrEqual) {
        this.lessOrEqual = lessOrEqual;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public List<LocalDate> getIncludes() {
        return includes;
    }

    public void setIncludes(List<LocalDate> includes) {
        this.includes = includes;
    }

    public List<LocalDate> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<LocalDate> excludes) {
        this.excludes = excludes;
    }

    @Override
    public boolean test(LocalDate aValue) {
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
