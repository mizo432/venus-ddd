package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    public CityInformation getCityInformation() {
        return getEntityInfo();
    }
}
