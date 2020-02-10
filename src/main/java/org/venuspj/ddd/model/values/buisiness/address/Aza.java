package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.entity.AbstractEntity;

public class Aza extends AbstractEntity<Aza, AzaIdentifier, AzaInformation> {

    Aza(AzaIdentifier anAzaIdentifier, AzaInformation anAzaInformation) {
        super(anAzaIdentifier, anAzaInformation);
    }

    public Aza() {
        super(AzaIdentifier.empty(), AzaInformation.empty());
    }

    public static Aza empty() {
        return new Aza();

    }

    public static Aza of(AzaIdentifier anAzaIdentifier, AzaInformation anAzaInformation) {
        return new Aza(anAzaIdentifier, anAzaInformation);

    }

    @JsonIgnore
    public AzaInformation getKoAzaInformation() {
        return getEntityInfo();
    }
}
