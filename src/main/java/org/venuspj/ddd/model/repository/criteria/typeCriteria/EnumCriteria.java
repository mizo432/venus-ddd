package org.venuspj.ddd.model.repository.criteria.typeCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;
import org.venuspj.ddd.model.repository.criteria.Criteria;
import org.venuspj.ddd.model.repository.criteria.expressionCriteria.ExcludeCriteria;
import org.venuspj.ddd.model.repository.criteria.expressionCriteria.IncludeCriteria;
import org.venuspj.ddd.model.repository.criteria.expressionCriteria.IsEqualToCriteria;

public class EnumCriteria<E extends Enum> extends AbstractCriteria<E> {

    private IsEqualToCriteria<E> isEqualCriteria = new IsEqualToCriteria<>(this);
    private IncludeCriteria<E> includeCriteria = new IncludeCriteria<>(this);
    private ExcludeCriteria<E> excludeCriteria = new ExcludeCriteria<>(this);

    public EnumCriteria(Criteria<?> parent) {
        super(parent);

    }

    public EnumCriteria() {

    }

    @Override
    public boolean test(E value) {
        return isEqualCriteria.test(value)
                && includeCriteria.test(value)
                && excludeCriteria.test(value);
    }

    public IsEqualToCriteria<E> getIsEqualCriteria() {
        return isEqualCriteria;

    }

    public IncludeCriteria<E> getIncludeCriteria() {
        return includeCriteria;

    }

    public ExcludeCriteria<E> getExcludeCriteria() {
        return excludeCriteria;

    }
}
