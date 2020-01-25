package org.venuspj.ddd.model.repository.criteria.typeCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;
import org.venuspj.ddd.model.repository.criteria.Criteria;
import org.venuspj.ddd.model.repository.criteria.expressionCriteria.IsEqualToCriteria;

public class EnumCriteria<E extends Enum> extends AbstractCriteria<E> {

    private IsEqualToCriteria<E> equalCriteria = new IsEqualToCriteria<>();

    public EnumCriteria(Criteria<?> parent) {
        super(parent);

    }

    @Override
    public boolean test(E value) {
        return equalCriteria.test(value);
    }
}
