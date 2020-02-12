package org.venuspj.ddd.model.values.buisiness.address;


import org.venuspj.ddd.model.values.buisiness.Name;

public class City extends AbstractCity<City> {

    City(CityIdentifier aCityIdentifier, CityCode aCityCode,
         Name aName,
         Name aKanaName) {
        super(aCityIdentifier, aCityCode, aName, aKanaName);

    }

    public City() {
        super();

    }

    public static City empty() {
        return new City();

    }

    public static City of(CityIdentifier aCityIdentifier, CityCode aCityCode,
                          Name aName,
                          Name aKanaName) {
        return new City(aCityIdentifier, aCityCode, aName, aKanaName);

    }

}
