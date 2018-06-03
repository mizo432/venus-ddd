package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.Entity;

public interface Pageable<T extends Entity<T>> {
    PageBreaker<T> pageBreaker();
}
