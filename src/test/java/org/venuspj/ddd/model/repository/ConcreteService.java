package org.venuspj.ddd.model.repository;

import org.venuspj.ddd.model.entity.AbstractEntityIdentifierTest;
import org.venuspj.ddd.model.entity.AbstractEntityTest;

public class ConcreteService {
    private final CrudRepository<AbstractEntityTest.ConcreteEntity, AbstractEntityIdentifierTest.ConcreteEntityIdentifier> concreteRepository;

    public ConcreteService(CrudRepository<AbstractEntityTest.ConcreteEntity, AbstractEntityIdentifierTest.ConcreteEntityIdentifier> aConcreteRepository) {
        concreteRepository = aConcreteRepository;
    }


    public ConcreteServiceResult execute(ConcreteServiceArg arg) {
        AbstractEntityTest.ConcreteEntity entity = new AbstractEntityTest.ConcreteEntity(arg.getConcreteEntityIdentifire());
        ConcreteServiceResult result = new ConcreteServiceResult();
        concreteRepository.store(entity);
        result.setConcreteEntity(entity);
        return result;


    }
}
