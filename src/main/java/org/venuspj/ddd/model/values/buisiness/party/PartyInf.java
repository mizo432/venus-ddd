package org.venuspj.ddd.model.values.buisiness.party;

import org.venuspj.ddd.model.values.Value;

public class PartyInf<PI extends PartyInf<PI>> implements Value<PI> {
    @Override
    public boolean sameValueAs(PI other) {
        return false;
    }
}
