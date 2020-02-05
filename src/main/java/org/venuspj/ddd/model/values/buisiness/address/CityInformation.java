package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.Name;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class CityInformation implements Value<CityInformation> {
    private Name name = Name.empty();

    public static CityInformation empty() {
        return new CityInformation();

    }

    @Override
    public boolean sameValueAs(CityInformation other) {
        return equals(other);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityInformation that = (CityInformation) o;
        return Objects2.equal(name, that.name);

    }

    @Override
    public int hashCode() {
        return Objects2.hash(name);

    }

    @Override
    public boolean isEmpty() {
        return name.isEmpty();

    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();

    }

}
