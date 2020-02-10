package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.entity.AbstractEntity;

public class OoAza extends AbstractEntity<OoAza, OoAzaIdentifier, OoAzaInformation> {

    OoAza(OoAzaIdentifier aOoAzaIdentifier, OoAzaInformation anOoAzaInformation) {
        super(aOoAzaIdentifier, anOoAzaInformation);
    }

    public OoAza() {
        super(OoAzaIdentifier.empty(), OoAzaInformation.empty());
    }

    public static OoAza empty() {
        return new OoAza();

    }

    public static OoAza of(OoAzaIdentifier anOoAzaIdentifier, OoAzaInformation anOoAzaInformation) {
        return new OoAza(anOoAzaIdentifier, anOoAzaInformation);


    }

    @JsonIgnore
    protected OoAzaInformation getAzaInformation() {
        return getEntityInfo();
    }

}
