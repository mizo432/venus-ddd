package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public class AzaIdentifier extends AbstractEntityLongIdentifier<Aza, AzaIdentifier> {
    public AzaIdentifier(Long aValue) {
        super(Aza.class, aValue);

    }

    public AzaIdentifier() {
        super(Aza.class);

    }

    public static AzaIdentifier empty() {
        return new AzaIdentifier();

    }

    public static AzaIdentifier of(long aValue) {
        return new AzaIdentifier(aValue);

    }

    @Override
    public boolean sameValueAs(AzaIdentifier other) {
        return equals(other);

    }

}
