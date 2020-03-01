package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityIdentifierList;

public class CityIdentifiers extends AbstractEntityIdentifierList<CityIdentifier, CityIdentifiers> {

    public static CityIdentifiers empty() {
        return new CityIdentifiers();
    }
}
