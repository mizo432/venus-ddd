package org.venuspj.ddd.model.forTest.infrastructure.db;

import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntity;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityIdentifier;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityRepository;
import org.venuspj.ddd.model.repository.OnMemoryCrudRepository;

import java.util.List;

public class ConcreteEntityDataSource extends OnMemoryCrudRepository<ConcreteEntity, ConcreteEntityIdentifier> implements ConcreteEntityRepository {

    public ConcreteEntityDataSource(List<ConcreteEntity> anyEntities) {
        super(anyEntities);
    }
}
