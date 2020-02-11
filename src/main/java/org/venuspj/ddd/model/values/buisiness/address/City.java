package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;

public class City extends AbstractEntity<City, CityIdentifier> {

    City(CityIdentifier aCityIdentifier) {
        super(aCityIdentifier);

    }

    public City() {
        super(CityIdentifier.empty());

    }

    public static City empty() {
        return new City();

    }

    public static City of(CityIdentifier aCityIdentifier) {
        return new City(aCityIdentifier);

    }

}
