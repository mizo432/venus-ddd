package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;
import org.venuspj.ddd.model.repository.criteria.Criteria;

public abstract class ExpressionCriteria<E> extends AbstractCriteria<E> {

    public ExpressionCriteria(Criteria<?> criteria) {
        super(criteria);
    }
}
