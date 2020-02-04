package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.values.buisiness.Name;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class Aza extends AbstractEntity<Aza, AzaIdentifier> {
    private Name name;

    Aza(AzaIdentifier aAzaIdentifier, Name aAzaName) {
        super(aAzaIdentifier);
        name = aAzaName;
    }

    public Aza() {
        super(AzaIdentifier.empty());
        name = Name.empty();
    }

    public static Aza empty() {
        return new Aza();

    }

    @Override
    public boolean sameValueAs(Aza other) {
        if (isNull(other))
            return false;

        return sameIdentifierAs(other) &&
                equal(name, other.name);
    }

    public boolean isEmpty() {
        return getIdentifier().isEmpty()
                && name.isEmpty();
    }
}
