package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public class OoAzaIdentifier extends AbstractEntityLongIdentifier<OoAza, OoAzaIdentifier> {
    public OoAzaIdentifier(Long aValue) {
        super(OoAza.class, aValue);

    }

    public OoAzaIdentifier() {
        super(OoAza.class);
    }

    public static OoAzaIdentifier empty() {
        return new OoAzaIdentifier();
    }

    public static OoAzaIdentifier of(Long aValue) {
        return new OoAzaIdentifier(aValue);
    }

    @Override
    public boolean sameValueAs(OoAzaIdentifier other) {
        return equals(other);

    }


}
