package org.venuspj.ddd.model.repository.criteria.expressionCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;
import org.venuspj.ddd.model.repository.criteria.Criteria;

public abstract class AbstractExpressionCriteria<E> extends AbstractCriteria<E> {

    protected AbstractExpressionCriteria(Criteria<?> criteria) {
        super(criteria);

    }

    protected AbstractExpressionCriteria() {

    }
}
