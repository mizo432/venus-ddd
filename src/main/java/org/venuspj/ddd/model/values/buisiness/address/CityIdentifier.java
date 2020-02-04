package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class CityIdentifier extends AbstractEntityLongIdentifier<City, CityIdentifier> {
    public CityIdentifier(Long aValue) {
        super(City.class, aValue);

    }

    public CityIdentifier() {
        super(City.class);
    }

    public static CityIdentifier empty() {
        return new CityIdentifier();
    }

    @Override
    public boolean sameValueAs(CityIdentifier other) {
        if (this == other) return true;
        return equal(this.kind, other.kind)
                && equal(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (isNull(o) || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CityIdentifier that = (CityIdentifier) o;
        return sameValueAs(that);
    }

}
