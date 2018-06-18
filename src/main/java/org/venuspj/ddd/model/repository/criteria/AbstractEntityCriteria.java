package org.venuspj.ddd.model.repository.criteria;

import org.venuspj.ddd.model.entity.Entity;
import org.venuspj.ddd.model.repository.EntityCriteria;

public abstract class AbstractEntityCriteria<E extends Entity<E, ?>> extends AbstractCriteria<E> implements EntityCriteria<E> {

    protected AbstractEntityCriteria(Criteria<?> parent) {
        super(parent);

    }
}
