package org.venuspj.ddd.model.repository;

import org.slf4j.Logger;
import org.venuspj.ddd.model.entity.Entities;
import org.venuspj.ddd.model.entity.Entity;
import org.venuspj.ddd.model.entity.EntityIdentifier;
import org.venuspj.util.collect.Maps2;
import org.venuspj.util.validate.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.venuspj.util.logger.LoggerFactory.getLogger;
import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * テストで使用するためのリポジトリ
 */
public class OnMemoryCrudRepository<T extends Entity<T>> implements CrudRepository<T>, Cloneable {

    private static final Logger LOGGER = getLogger();

    private final Map<EntityIdentifier<T>, T> entities = Maps2.newHashMap();

    public OnMemoryCrudRepository(List<T> anyEntities) {
        for (T entity : anyEntities)
            store(entity);

    }

    private List<T> asEntitiesList() {
        List<T> result = new ArrayList<T>(entities.size());
        for (T entity : entities.values()) {
            result.add(entity.clone());
        }
        return result;
    }

    @Override
    public boolean contains(EntityIdentifier<T> identifier) {
        Validate.notNull(identifier);
        return entities.containsKey(identifier);
    }

    @Override
    public boolean contains(T entity) {
        Validate.notNull(entity);
        return contains(entity.getIdentifier());
    }

    @Override
    public T resolve(EntityIdentifier<T> identifier) {
        Validate.notNull(identifier);
        T result = entities.get(identifier);
        if(isNull(result)) throw new EntityNotFoundRuntimeException(identifier);
        return result;
    }

    @Override
    public T resolve(EntityCriteria<T> criteria) {
        List<T> result = resolveAll(criteria);
        if(result.isEmpty()) throw new EntityNotFoundRuntimeException(criteria);
        if(hasMultiElements(result)) throw new EntityNotFoundRuntimeException(criteria);
        return result.get(0);
    }

    private boolean hasMultiElements(List<T> list) {
        return list.size() > 1;
    }

    @Override
    public List<T> resolveAll(EntityCriteria<T> criteria) {
        return entities
                .entrySet()
                .stream()
                .filter(entityIdentifierTEntry -> criteria.test(entityIdentifierTEntry.getValue()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }


    @Override
    public boolean contains(EntityCriteria<T> criteria) {
        return false;
    }

    @Override
    public void store(Entities<T> entities) {
        entities.asList()
                .stream()
                .forEach(entity ->store(entity));
    }


    @Override
    public void store(T entity) {
        Validate.notNull(entity);
        entities.put(entity.getIdentifier(), entity.clone());
    }

    @Override
    public void delete(Entities<T> entities) {
        entities.asList()
                .stream()
                .filter(entityIdentifierTEntry->entities.contains(entityIdentifierTEntry))
                .forEach(entity ->this.entities.remove(entity.getIdentifier()));

    }

    @Override
    public void delete(EntityCriteria<T> criteria) {
        asEntitiesList()
                .stream()
                .filter(element->criteria.test(element))
                .forEach(element->delete(element.getIdentifier()));

    }

    @Override
    public void delete(EntityIdentifier<T> identifier) {
        Validate.notNull(identifier);
        entities.remove(identifier);
    }

    @Override
    public void delete(T entity) {
        Validate.notNull(entity);
        delete(entity.getIdentifier());
    }

    public List<T> resolveAll() {
        return asEntitiesList();
    }
}
