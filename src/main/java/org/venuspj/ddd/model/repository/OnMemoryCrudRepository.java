package org.venuspj.ddd.model.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.venuspj.ddd.model.entity.Entity;
import org.venuspj.ddd.model.entity.EntityIdentifier;
import org.venuspj.ddd.model.value.ListValue;
import org.venuspj.util.collect.Maps2;
import org.venuspj.util.validate.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.venuspj.util.objects2.Objects2.isNull;

/**
 * テストで使用するためのリポジトリ
 */
public class OnMemoryCrudRepository<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI, ?>> implements CrudRepository<E, EI>, Cloneable {

    private static final Logger LOGGER = LoggerFactory.getLogger(OnMemoryCrudRepository.class);

    private final Map<EI, E> entities = Maps2.newHashMap();

    public OnMemoryCrudRepository(List<E> anyEntities) {
        for (E entity : anyEntities)
            store(entity);

    }

    private List<E> asEntitiesList() {
        List<E> result = new ArrayList<E>(entities.size());
        for (E entity : entities.values()) {
            E clonedEntity = (E) entity.clone();
            result.add(clonedEntity);
        }
        return result;
    }

    @Override
    public boolean contains(EI identifier) {
        Validate.notNull(identifier);
        return entities.containsKey(identifier);
    }

    @Override
    public E resolve(EI identifier) {
        Validate.notNull(identifier);
        E result = entities.get(identifier);
        if (isNull(result)) throw new EntityNotFoundRuntimeException(identifier);
        return result;
    }

    @Override
    public E resolve(EntityCriteria<E> criteria) {
        List<E> result = resolveAll(criteria);
        if (result.isEmpty()) throw new EntityNotFoundRuntimeException(criteria);
        if (hasMultiElements(result)) throw new EntityNotFoundRuntimeException(criteria);
        return result.get(0);
    }

    private boolean hasMultiElements(List<E> list) {
        return list.size() > 1;
    }

    @Override
    public List<E> resolveAll(EntityCriteria<E> criteria) {
        return entities
                .entrySet()
                .stream()
                .filter(entityIdentifierTEntry -> criteria.test(entityIdentifierTEntry.getValue()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }


    @Override
    public boolean contains(EntityCriteria<E> criteria) {
        return false;
    }

    @Override
    public void store(ListValue<E> entities) {
        entities.asList()
                .forEach(this::store);
    }


    @Override
    public void store(E entity) {
        Validate.notNull(entity);
        entities.put(entity.getIdentifier(), entity);
    }

    @Override
    public void delete(ListValue<E> entities) {
        entities.asList()
                .stream()
                .forEach(entity -> this.entities.remove(entity.getIdentifier()));

    }

    @Override
    public void delete(EntityCriteria<E> criteria) {
        asEntitiesList()
                .stream()
                .filter(criteria::test)
                .forEach(element -> this.delete(element.getIdentifier()));

    }

    @Override
    public void delete(EI identifier) {
        Validate.notNull(identifier);
        entities.remove(identifier);
    }

    public List<E> resolveAll() {
        return asEntitiesList();
    }
}
