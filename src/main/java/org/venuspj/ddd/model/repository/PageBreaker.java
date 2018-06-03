package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.Entity;

import java.util.function.Predicate;

/**
 */
public interface PageBreaker<E extends Entity> extends Predicate<E> {
}
