package org.venuspj.ddd.model.values.buisiness.party;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.NamedObject;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class AbstractPartyInf<API extends AbstractPartyInf<API, NO>, NO extends NamedObject<NO>> implements Value<API> {
    protected NO namedObject;

    protected AbstractPartyInf(NO aNamedObject) {
        namedObject = aNamedObject;
    }

    @Override
    public boolean sameValueAs(API other) {
        if (isNull(other))
            return false;
        return equal(namedObject, other.namedObject);
    }

    protected NO getNamedObject() {
        return namedObject;
    }

}
