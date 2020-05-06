package org.venuspj.ddd.model.criterias;

import org.venuspj.ddd.model.criterias.predicates.EqualToPredicate;
import org.venuspj.ddd.model.criterias.predicates.IsNotNullPredicate;
import org.venuspj.ddd.model.criterias.predicates.IsNullPredicate;
import org.venuspj.ddd.model.criterias.predicates.NotEqualToPredicate;

import java.io.Serializable;
import java.util.function.Predicate;

/**
 * Boolean 用の検索条件
 */
public class BooleanCriteria implements Serializable, Predicate<Boolean> {

    private static final long serialVersionUID = 1L;

    private Boolean equalTo;
    private Boolean notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;

    public Boolean getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(Boolean equalTo) {
        this.equalTo = equalTo;
    }

    public Boolean getNotEqualTo() {
        return notEqualTo;
    }

    public void setNotEqualTo(Boolean notEqualTo) {
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

    @Override
    public boolean test(Boolean aValue) {
        return EqualToPredicate.of(equalTo)
                .and(NotEqualToPredicate.of(notEqualTo))
                .and(IsNullPredicate.of(isNull))
                .and(IsNotNullPredicate.of(isNotNull))
                .test(aValue);

    }

}
