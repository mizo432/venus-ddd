package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.values.buisiness.Name;

public class AbstractCity<C extends AbstractCity<C>> extends AbstractEntity<C, CityIdentifier> {

    private CityCode cityCode = CityCode.empty();
    private Name name = Name.empty();
    private Name kanaName = Name.empty();


    public AbstractCity() {
        super(CityIdentifier.empty());

    }

    protected AbstractCity(CityIdentifier aCityIdentifier, CityCode aCityCode,
                           Name aName,
                           Name aKanaName) {
        super(aCityIdentifier);
        cityCode = aCityCode;
        name = aKanaName;
        kanaName = aKanaName;

    }

    /*
    public static City empty() {
        return new City();

    }

    public static City of(CityIdentifier aCityIdentifier) {
        return new City(aCityIdentifier);

    }
     */

}
