package org.venuspj.ddd.model.criterias;

import org.venuspj.ddd.model.criterias.predicates.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.function.Predicate;

import static org.venuspj.util.collect.Lists2.newArrayList;

public class EnumCriteria<T extends Enum<?>> implements Serializable, Predicate<T> {

    private static final long serialVersionUID = 1L;
    private T equalTo;
    private T notEqualTo;
    private Boolean isNull;
    private Boolean isNotNull;
    private ArrayList<T> includes = newArrayList();
    private ArrayList<T> excludes = newArrayList();

    public T getNotEqualTo() {
        return notEqualTo;
    }

    public Boolean getNull() {
        return isNull;
    }

    public Boolean getNotNull() {
        return isNotNull;
    }

    public ArrayList<T> getIncludes() {
        return includes;
    }

    public ArrayList<T> getExcludes() {
        return excludes;
    }

    public T getEqualTo() {
        return equalTo;
    }

    public void setEqualTo(T equalTo) {
        this.equalTo = equalTo;
    }

    public void setNotEqualTo(T notEqualTo) {
        this.notEqualTo = notEqualTo;
    }

    public void setNull(Boolean aNull) {
        isNull = aNull;
    }

    public void setNotNull(Boolean notNull) {
        isNotNull = notNull;
    }

    @Override
    public boolean test(T aValue) {
        return EqualToPredicate.of(equalTo)
                .and(NotEqualToPredicate.of(notEqualTo))
                .and(IsNullPredicate.of(isNull))
                .and(IsNotNullPredicate.of(isNotNull))
                .and(IncludesPredicate.of(includes))
                .and(ExcludesPredicate.of(excludes))
                .test(aValue);

    }

}
