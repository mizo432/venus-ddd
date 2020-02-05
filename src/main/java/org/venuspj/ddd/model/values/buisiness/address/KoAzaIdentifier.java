package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public class KoAzaIdentifier extends AbstractEntityLongIdentifier<KoAza, KoAzaIdentifier> {
    public KoAzaIdentifier(Long aValue) {
        super(KoAza.class, aValue);

    }

    public KoAzaIdentifier() {
        super(KoAza.class);

    }

    public static KoAzaIdentifier empty() {
        return new KoAzaIdentifier();

    }

    public static KoAzaIdentifier of(long aValue) {
        return new KoAzaIdentifier(aValue);

    }

    @Override
    public boolean sameValueAs(KoAzaIdentifier other) {
        return equals(other);

    }

}
