package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;

public class Aza extends AbstractEntity<Aza, AzaIdentifier, AzaInformation> {

    Aza(AzaIdentifier aAzaIdentifier, AzaInformation anAzaInformation) {
        super(aAzaIdentifier, anAzaInformation);
    }

    public Aza() {
        super(AzaIdentifier.empty(), AzaInformation.empty());
    }

    public static Aza empty() {
        return new Aza();

    }

}
