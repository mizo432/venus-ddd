package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntities;

import java.util.Collection;

/**
 * 住所の字（字）
 */
public class OoAzas extends AbstractEntities<OoAza, OoAzaIdentifier, OoAzas> {

    public OoAzas() {

    }

    OoAzas(Collection<OoAza> aCollection) {
        super(aCollection);

    }

    public static OoAzas of(Collection<OoAza> aCollection) {
        return new OoAzas(aCollection);

    }

    public static OoAzas empty() {
        return new OoAzas();
    }
}
