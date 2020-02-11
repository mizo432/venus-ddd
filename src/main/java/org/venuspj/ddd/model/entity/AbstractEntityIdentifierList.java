package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.values.primitives.AbstractListValue;

public abstract class AbstractEntityIdentifierList<EI extends EntityIdentifier<?, EI>, EIL extends AbstractEntityIdentifierList<EI, EIL>> extends AbstractListValue<EI, EIL> {

}
