package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.ConcreteEntity;
import org.venuspj.ddd.model.entity.ConcreteEntityIdentifier;

public class ConcreteService {
    private final CrudRepository<ConcreteEntity, ConcreteEntityIdentifier> concreteRepository;

    public ConcreteService(CrudRepository<ConcreteEntity, ConcreteEntityIdentifier> aConcreteRepository) {
        concreteRepository = aConcreteRepository;
    }


    public ConcreteServiceResult execute(ConcreteServiceArg arg) {
        ConcreteEntity entity = new ConcreteEntity(arg.getConcreteEntityIdentifire());
        ConcreteServiceResult result = new ConcreteServiceResult();
        concreteRepository.store(entity);
        result.setConcreteEntity(entity);
        return result;


    }
}
