package org.venuspj.ddd.model.entity.entities;

import org.venuspj.ddd.model.entity.Entity;
import org.venuspj.ddd.model.entity.EntityIdentifier;

import java.util.Collection;
import java.util.List;

import static org.venuspj.util.collect.Lists2.newArrayList;
import static org.venuspj.util.collect.Lists2.unmodifiableList;

public abstract class AbstractEntities<E extends Entity<E, EI>, T, EI extends EntityIdentifier<E, EI, T>> {

    protected List<E> list = newArrayList();

    protected AbstractEntities(Collection<E> entity) {
        this.list.addAll(entity);
    }

    protected AbstractEntities(){

    }

    public List<E> getList() {
        return unmodifiableList(list);
    }
}
