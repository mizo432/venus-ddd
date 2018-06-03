package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.Entity;

import java.util.Comparator;

public interface PagingAndSortingRepository<T extends Entity<T>> extends CrudRepository<T> {

    Page<T> findAll(Pageable<T> pageable);

    Iterable<T> findAll(Comparator<T> sort);

    Page<T> findAll(Pageable<T> pageable, Comparator<T> sortCondition);

}
