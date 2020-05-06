package org.venuspj.ddd.model.criterias;

import java.io.Serializable;
import java.util.function.Predicate;

public abstract class AbstractCriteria<S extends Serializable> implements Serializable,
        Predicate<S> {

}
