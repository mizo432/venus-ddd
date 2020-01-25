package org.venuspj.ddd.model.values.buisiness.party;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.values.buisiness.name.NamedObject;

import static org.venuspj.util.objects2.Objects2.isNull;

public class Party<P extends Party<P, PI, API, NO>, PI extends PartyIdentifier<P, PI>, API extends AbstractPartyInf<API, NO>, NO extends NamedObject<NO>> extends AbstractEntity<P, PI> {
    protected API partyInf;

    protected Party(PI aPartyIdentifier, API aPartyInf) {
        super(aPartyIdentifier);
        partyInf = aPartyInf;

    }

    @Override
    public boolean sameValueAs(P other) {
        if (isNull(other))
            return false;

        return sameIdentifierAs(other) &&
                partyInf.sameValueAs(other.partyInf);
    }
}
