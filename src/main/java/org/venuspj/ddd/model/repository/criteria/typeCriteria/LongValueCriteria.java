package org.venuspj.ddd.model.repository.criteria.typeCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;
import org.venuspj.ddd.model.repository.criteria.Criteria;
import org.venuspj.ddd.model.repository.criteria.expressionCriteria.IsEqualToCriteria;
import org.venuspj.ddd.model.values.primitives.LongValue;

public class LongValueCriteria extends AbstractCriteria<LongValue<?>> {
    private IsEqualToCriteria<LongValue<?>> isEqualToCriteria = new IsEqualToCriteria<>();

    public LongValueCriteria(Criteria<?> parent) {
        super(parent);

    }

    public LongValueCriteria() {
        super();

    }

    @Override
    public boolean test(LongValue<?> value) {
        return testChildren(value, isEqualToCriteria);

    }

    public IsEqualToCriteria<LongValue<?>> isEqualToCriteria() {
        return isEqualToCriteria;
    }

}
