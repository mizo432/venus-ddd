package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public class CityIdentifier extends AbstractEntityLongIdentifier<CityIdentifier> {
    public CityIdentifier(Long aValue) {
        super(City.class, aValue);

    }

    public CityIdentifier() {
        super(City.class);

    }

    public static CityIdentifier empty() {
        return new CityIdentifier();

    }

    public static CityIdentifier of(Long aValue) {
        return new CityIdentifier(aValue);

    }

}
