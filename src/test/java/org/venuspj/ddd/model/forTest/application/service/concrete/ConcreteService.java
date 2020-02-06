package org.venuspj.ddd.model.forTest.application.service.concrete;

import org.venuspj.ddd.model.forTest.application.service.concrete.arg.ConcreteServiceArg;
import org.venuspj.ddd.model.forTest.application.service.concrete.result.ConcreteServiceResult;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntity;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteEntityRepository;
import org.venuspj.ddd.model.forTest.model.concrete.entities.ConcreteInfo;

public class ConcreteService {
    private final ConcreteEntityRepository concreteEntityRepository;

    public ConcreteService(ConcreteEntityRepository aConcreteEntityRepository) {
        concreteEntityRepository = aConcreteEntityRepository;
    }


    public ConcreteServiceResult execute(ConcreteServiceArg arg) {
        ConcreteServiceResult result = new ConcreteServiceResult();
        ConcreteEntity entity = new ConcreteEntity(arg.getConcreteEntityIdentifire(), ConcreteInfo.empty());
        concreteEntityRepository.store(entity);
        result.setConcreteEntity(entity);
        return result;

    }
}
