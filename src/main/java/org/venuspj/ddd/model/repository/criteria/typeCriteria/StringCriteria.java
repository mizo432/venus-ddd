package org.venuspj.ddd.model.repository.criteria.typeCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;
import org.venuspj.ddd.model.repository.criteria.Criteria;
import org.venuspj.ddd.model.repository.criteria.expressionCriteria.AbstractEqualCriteria;

public  class StringCriteria extends AbstractCriteria<String> {

    private AbstractEqualCriteria<String> equalCriteria = new AbstractEqualCriteria<>(this);

    public StringCriteria(Criteria<?> parent){
        super(parent);

    }

    @Override
    public boolean test(String value) {
        return equalCriteria.test(value);
    }
}
