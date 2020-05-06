package org.venuspj.ddd.model.criterias;


import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.util.Date;
import java.util.function.Predicate;

/**
 * Date 用の検索条件
 */
public class DateCriteria implements Serializable, Predicate<Date> {

    private static final long serialVersionUID = 1L;

    private Date equalTo;
    private Date notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private Date moreThan;
    private Date moreOrEqual;
    private Date lessThan;
    private Date lessOrEqual;
    private Date from;
    private Date to;

    public Date getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(Date equalTo) {
        this.equalTo = equalTo;
    }

    public Date getNotEqualTo() {
        return notEqualTo;
    }

    public void setNotEqualTo(Date notEqualTo) {
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

    public Date getMoreThan() {
        return moreThan;
    }

    public void setMoreThan(Date moreThan) {
        this.moreThan = moreThan;
    }

    public Date getMoreOrEqual() {
        return moreOrEqual;
    }

    public void setMoreOrEqual(Date moreOrEqual) {
        this.moreOrEqual = moreOrEqual;
    }

    public Date getLessThan() {
        return lessThan;
    }

    public void setLessThan(Date lessThan) {
        this.lessThan = lessThan;
    }

    public Date getLessOrEqual() {
        return lessOrEqual;
    }

    public void setLessOrEqual(Date lessOrEqual) {
        this.lessOrEqual = lessOrEqual;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }


    @Override
    public boolean test(Date aValue) {
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
