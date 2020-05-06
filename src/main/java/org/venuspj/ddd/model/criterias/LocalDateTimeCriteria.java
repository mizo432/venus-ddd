package org.venuspj.ddd.model.criterias;

import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.function.Predicate;

/**
 * LocalDateTime 用の検索条件
 */
public class LocalDateTimeCriteria implements Serializable, Predicate<LocalDateTime> {

    private static final long serialVersionUID = 1L;

    private LocalDateTime equalTo;
    private LocalDateTime notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private LocalDateTime moreThan;
    private LocalDateTime moreOrEqual;
    private LocalDateTime lessThan;
    private LocalDateTime lessOrEqual;
    private LocalDateTime from;
    private LocalDateTime to;

    public LocalDateTime getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(LocalDateTime equalTo) {
        this.equalTo = equalTo;
    }

    public LocalDateTime getNotEqualTo() {
        return notEqualTo;
    }

    public void setNotEqualTo(LocalDateTime notEqualTo) {
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

    public LocalDateTime getMoreThan() {
        return moreThan;
    }

    public void setMoreThan(LocalDateTime moreThan) {
        this.moreThan = moreThan;
    }

    public LocalDateTime getMoreOrEqual() {
        return moreOrEqual;
    }

    public void setMoreOrEqual(LocalDateTime moreOrEqual) {
        this.moreOrEqual = moreOrEqual;
    }

    public LocalDateTime getLessThan() {
        return lessThan;
    }

    public void setLessThan(LocalDateTime lessThan) {
        this.lessThan = lessThan;
    }

    public LocalDateTime getLessOrEqual() {
        return lessOrEqual;
    }

    public void setLessOrEqual(LocalDateTime lessOrEqual) {
        this.lessOrEqual = lessOrEqual;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }

    @Override
    public boolean test(LocalDateTime aValue) {
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
