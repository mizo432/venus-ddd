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

    public static class CityBuilder

            extends AbstractCityBuilder<City, CityBuilder> {


        @Override
        protected void apply(City vo, CityBuilder builder) {
            super.apply(vo, builder);

        }

        @Override
        protected City createValueObject() {
            return new City(identifier,
                    cityCode,
                    name,
                    kanaName);
        }

        @Override
        protected CityBuilder getThis() {
            return this;
        }

        @Override
        protected CityBuilder newInstance() {
            return new CityBuilder();
        }
    }

}
