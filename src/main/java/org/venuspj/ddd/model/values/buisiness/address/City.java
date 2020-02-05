package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;

public class City extends AbstractEntity<City, CityIdentifier, CityInformation> {

    City(CityIdentifier aCityIdentifier, CityInformation aCityInformation) {
        super(aCityIdentifier, aCityInformation);
    }

    public City() {
        super(CityIdentifier.empty(), CityInformation.empty());

    }

    public static City empty() {
        return new City();
    }

    public static City of(CityIdentifier aCityIdentifier, CityInformation aCityInformation) {
        return new City(aCityIdentifier, aCityInformation);
    }

    public CityInformation getCityInformation() {
        return getEntityInfo();
    }
}
