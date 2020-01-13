package org.venuspj.ddd.model.repository.criteria.typeCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;
import org.venuspj.ddd.model.repository.criteria.Criteria;
import org.venuspj.ddd.model.repository.criteria.expressionCriteria.EqualCriteriaAbstract;

public  class StringCriteria extends AbstractCriteria<String> {

    private EqualCriteriaAbstract<String> equalCriteria = new EqualCriteriaAbstract<>(this);

    public StringCriteria(Criteria<?> parent){
        super(parent);

    }

    @Override
    public boolean test(String value) {
        return equalCriteria.test(value);
    }
}
