package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.entity.AbstractEntity;

public class KoAza extends AbstractEntity<KoAza, KoAzaIdentifier, KoAzaInformation> {

    KoAza(KoAzaIdentifier aKoAzaIdentifier, KoAzaInformation aKoAzaInformation) {
        super(aKoAzaIdentifier, aKoAzaInformation);
    }

    public KoAza() {
        super(KoAzaIdentifier.empty(), KoAzaInformation.empty());
    }

    public static KoAza empty() {
        return new KoAza();

    }

    public static KoAza of(KoAzaIdentifier aKoAzaIdentifier, KoAzaInformation aKoAzaInformation) {
        return new KoAza(aKoAzaIdentifier, aKoAzaInformation);

    }

    @JsonIgnore
    public KoAzaInformation getKoAzaInformation() {
        return getEntityInfo();
    }
}
