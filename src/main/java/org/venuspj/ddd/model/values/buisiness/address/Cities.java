package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntities;

import java.util.Collection;

public class Cities extends AbstractEntities<City, CityIdentifier, Cities> {

    public Cities() {

    }

    Cities(Collection<City> aCollection) {
        super(aCollection);

    }

    public static Cities of(Collection<City> aCollection) {
        return new Cities(aCollection);

    }

    public static Cities empty() {
        return new Cities();

    }
}
