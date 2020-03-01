package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntities;

import java.util.Collection;

public class Azas extends AbstractEntities<Aza, AzaIdentifier, Azas> {

    public Azas() {

    }

    Azas(Collection<Aza> aCollection) {
        super(aCollection);

    }

    public static Azas of(Collection<Aza> aCollection) {
        return new Azas(aCollection);

    }

    public static Azas empty() {
        return new Azas();
    }
}
