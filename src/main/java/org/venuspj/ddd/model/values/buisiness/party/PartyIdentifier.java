package org.venuspj.ddd.model.values.buisiness.party;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class PartyIdentifier<P extends Party<P, PI>, PI extends PartyIdentifier<P, PI>> extends AbstractEntityLongIdentifier<P, PI> {
    protected PartyIdentifier(String aKey, Long aValue) {
        super(aKey, aValue);

    }

    protected PartyIdentifier(String aKey) {
        super(aKey);

    }

    @Override
    public boolean sameValueAs(PI other) {
        if (isNull(other))
            return false;

        return equal(kind, other.kind) &&
                equal(value, other.value);

    }
}
