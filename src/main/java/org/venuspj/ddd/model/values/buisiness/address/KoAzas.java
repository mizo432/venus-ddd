package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntities;

import java.util.Collection;

public class KoAzas extends AbstractEntities<KoAza, KoAzaIdentifier, KoAzas> {

    public KoAzas() {

    }

    KoAzas(Collection<KoAza> aCollection) {
        super(aCollection);

    }

    public static KoAzas of(Collection<KoAza> aCollection) {
        return new KoAzas(aCollection);

    }

    public static KoAzas empty() {
        return new KoAzas();
    }
}
