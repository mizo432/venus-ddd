package org.venuspj.ddd.model.repository.criteria.typeCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;
import org.venuspj.ddd.model.repository.criteria.Criteria;
import org.venuspj.ddd.model.repository.criteria.expressionCriteria.IsEqualToCriteria;

public  class StringCriteria extends AbstractCriteria<String> {

    private IsEqualToCriteria<String> equalCriteria = new IsEqualToCriteria<>();

    public StringCriteria(Criteria<?> parent){
        super(parent);

    }

    @Override
    public boolean test(String value) {
        return equalCriteria.test(value);
    }
}
