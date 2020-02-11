package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;

public class OoAza extends AbstractEntity<OoAza, OoAzaIdentifier> {

    OoAza(OoAzaIdentifier aOoAzaIdentifier) {
        super(aOoAzaIdentifier);
    }

    public OoAza() {
        super(OoAzaIdentifier.empty());

    }

    public static OoAza empty() {
        return new OoAza();

    }

    public static OoAza of(OoAzaIdentifier anOoAzaIdentifier) {
        return new OoAza(anOoAzaIdentifier);

    }

}
