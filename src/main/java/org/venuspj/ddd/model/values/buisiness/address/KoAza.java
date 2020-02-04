package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.values.buisiness.Name;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class KoAza extends AbstractEntity<KoAza, KoAzaIdentifier> {
    private Name name;

    KoAza(KoAzaIdentifier aKoAzaIdentifier, Name aKoAzaName) {
        super(aKoAzaIdentifier);
        name = aKoAzaName;
    }

    public KoAza() {
        super(KoAzaIdentifier.empty());
        name = Name.empty();
    }

    public static KoAza empty() {
        return new KoAza();
    }

    @Override
    public boolean sameValueAs(KoAza other) {
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
