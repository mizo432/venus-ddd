package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.Name;

public class CityInformation implements Value<CityInformation> {
    private Name name = Name.empty();

    public static CityInformation empty() {
        return new CityInformation();
    }

    @Override
    public boolean sameValueAs(CityInformation other) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return name.isEmpty();
    }
}
