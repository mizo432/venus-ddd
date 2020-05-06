package org.venuspj.ddd.model.criterias;

import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.function.Predicate;

/**
 * Time 用の検索条件
 */
public class TimeCriteria implements Serializable, Predicate<LocalTime> {

    private static final long serialVersionUID = 1L;

    private LocalTime equalTo;
    private LocalTime notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private LocalTime moreThan;
    private LocalTime moreOrEqual;
    private LocalTime lessThan;
    private LocalTime lessOrEqual;
    private LocalTime from;
    private LocalTime to;

    public LocalTime getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(LocalTime equalTo) {
        this.equalTo = equalTo;

    }

    public LocalTime getNotEqualTo() {
        return notEqualTo;

    }

    public void setNotEqualTo(LocalTime notEqualTo) {
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

    public LocalTime getMoreThan() {
        return moreThan;

    }

    public void setMoreThan(LocalTime moreThan) {
        this.moreThan = moreThan;

    }

    public LocalTime getMoreOrEqual() {
        return moreOrEqual;

    }

    public void setMoreOrEqual(LocalTime moreOrEqual) {
        this.moreOrEqual = moreOrEqual;

    }

    public LocalTime getLessThan() {
        return lessThan;

    }

    public void setLessThan(LocalTime lessThan) {
        this.lessThan = lessThan;

    }

    public LocalTime getLessOrEqual() {
        return lessOrEqual;

    }

    public void setLessOrEqual(LocalTime lessOrEqual) {
        this.lessOrEqual = lessOrEqual;

    }

    public LocalTime getFrom() {
        return from;
    }

    public void setFrom(LocalTime from) {
        this.from = from;
    }

    public LocalTime getTo() {
        return to;
    }

    public void setTo(LocalTime to) {
        this.to = to;
    }

    @Override
    public boolean test(LocalTime aValue) {
        return EqualToPredicate.of(equalTo)
                .and(NotEqualToPredicate.of(notEqualTo))
                .and(IsNullPredicate.of(isNull))
                .and(IsNotNullPredicate.of(isNotNull))
                .and(MoreThanPredicate.of(moreThan))
                .and(MoreOrEqualPredicate.of(moreOrEqual))
                .and(LessThanPredicate.of(lessThan))
                .and(LessOrEqualPredicate.of(lessOrEqual))
                .and(BetweenPredicate.of(from, to))
                .test(aValue);

    }
}
