package org.venuspj.ddd.model.values.buisiness.address.aza;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.values.buisiness.name.Name;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class Aza extends AbstractEntity<Aza, AzaIdentifier> {
    private Name name;

    Aza(AzaIdentifier aAzaIdentifier, Name aAzaName) {
        super(aAzaIdentifier);
        name = aAzaName;
    }

    @Override
    public boolean sameValueAs(Aza other) {
        if (isNull(other))
            return false;

        return sameIdentifierAs(other) &&
                equal(name, other.name);
    }
}
