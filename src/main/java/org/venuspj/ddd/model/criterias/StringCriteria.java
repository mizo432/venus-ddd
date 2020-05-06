package org.venuspj.ddd.model.criterias;


import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;

import static org.venuspj.util.collect.Lists2.newArrayList;


/**
 * String 用の検索条件
 */
public class StringCriteria implements Serializable, Predicate<String> {

    private static final long serialVersionUID = 1L;

    private String equalTo;
    private String notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private String moreThan;
    private String moreOrEqual;
    private String lessThan;
    private String lessOrEqual;
    private String from;
    private String to;
    private List<String> includes = newArrayList();
    private List<String> excludes = newArrayList();
    private String partialMatch;
    private String forwardMatch;

    public void setForwardMatch(String forwardMatch) {
        this.forwardMatch = forwardMatch;
    }

    public void setBackwardMatch(String backwardMatch) {
        this.backwardMatch = backwardMatch;
    }

    private String backwardMatch;

    public String getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(String equalTo) {
        this.equalTo = equalTo;
    }

    public String getNotEqualTo() {
        return notEqualTo;
    }

    public void setNotEqualTo(String notEqualTo) {
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

    public String getMoreThan() {
        return moreThan;
    }

    public void setMoreThan(String moreThan) {
        this.moreThan = moreThan;
    }

    public String getMoreOrEqual() {
        return moreOrEqual;
    }

    public void setMoreOrEqual(String moreOrEqual) {
        this.moreOrEqual = moreOrEqual;
    }

    public String getLessThan() {
        return lessThan;
    }

    public void setLessThan(String lessThan) {
        this.lessThan = lessThan;
    }

    public String getLessOrEqual() {
        return lessOrEqual;
    }

    public void setLessOrEqual(String lessOrEqual) {
        this.lessOrEqual = lessOrEqual;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<String> getIncludes() {
        return includes;
    }

    public void setIncludes(List<String> includes) {
        this.includes = includes;
    }

    public List<String> getExcludes() {
        return excludes;
    }

    public void setExcludes(List<String> excludes) {
        this.excludes = excludes;
    }

    public String getPartialMatch() {
        return partialMatch;
    }

    public void setPartialMatch(String partialMatch) {
        this.partialMatch = partialMatch;
    }

    public String getForwardMatch() {
        return forwardMatch;
    }

    public String getBackwardMatch() {
        return backwardMatch;
    }

    @Override
    public boolean test(String aValue) {
        /*
            private String partialMatch;
    private String forwardMatch;

         */
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
                .and(PartialMatchPredicate.of(partialMatch))
                .and(ForwardMatchPredicate.of(forwardMatch))
                .test(aValue);
    }
}
