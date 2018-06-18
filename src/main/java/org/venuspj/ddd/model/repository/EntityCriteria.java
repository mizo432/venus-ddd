package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.Entity;
import org.venuspj.ddd.model.repository.criteria.Criteria;

public interface EntityCriteria<E extends Entity<E, ?>> extends Criteria<E> {

}
