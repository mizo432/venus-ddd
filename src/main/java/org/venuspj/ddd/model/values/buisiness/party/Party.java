package org.venuspj.ddd.model.values.buisiness.party;

import org.venuspj.ddd.model.entity.AbstractEntity;

import static org.venuspj.util.objects2.Objects2.isNull;

public class Party<P extends Party<P, PI>, PI extends PartyIdentifier<P, PI>> extends AbstractEntity<P, PI> {
    protected PartyInf partyInf = DefaultPartyInf.empty();

    @Override
    public boolean sameValueAs(P other) {
        if (isNull(other))
            return false;

        return sameIdentifierAs(other) &&
                partyInf.sameValueAs(other.partyInf);
    }
}
