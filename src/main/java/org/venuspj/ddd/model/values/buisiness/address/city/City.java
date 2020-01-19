package org.venuspj.ddd.model.values.buisiness.address.city;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.values.buisiness.name.Name;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class City extends AbstractEntity<City, CityIdentifier> {
    private Name name;

    City(CityIdentifier aCityIdentifier, Name aCityName) {
        super(aCityIdentifier);
        name = aCityName;
    }

    @Override
    public boolean sameValueAs(City other) {
        if (isNull(other))
            return false;

        return sameIdentifierAs(other) &&
                equal(name, other.name);
    }
}
