package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.value.StringValue;

/**
 * Created by mizoguchi on 2017/07/01.
 */
public interface StringIdentifierValue<E extends Entity<E, EI>, EI extends EntityIdentifier<E, EI, String>>
        extends EntityIdentifier<E, EI, String> {

}
