package org.venuspj.ddd.model.repository.criteria.typeCriteria;

import org.venuspj.ddd.model.repository.criteria.AbstractCriteria;
import org.venuspj.ddd.model.repository.criteria.Criteria;

public class IntegerCriteria  extends AbstractCriteria<Integer> {

    public IntegerCriteria(Criteria<?> parent) {
        super(parent);

    }

    @Override
    public boolean test(Integer value) {
        return false;

    }
}
