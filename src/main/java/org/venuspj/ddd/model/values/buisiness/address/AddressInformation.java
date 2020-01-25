package org.venuspj.ddd.model.values.buisiness.address;


import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.address.aza.Aza;
import org.venuspj.ddd.model.values.buisiness.address.city.City;
import org.venuspj.ddd.model.values.buisiness.address.koaza.KoAza;
import org.venuspj.ddd.model.values.buisiness.address.prefecture.Prefecture;

import static org.venuspj.util.objects2.Objects2.*;

public class AddressInformation implements Value<AddressInformation> {
    private AddressCode addressCode;
    private Prefecture prefecture;
    private City city;
    private KoAza koAza;
    private Aza aza;

    AddressInformation(AddressCode anAddressCode, Prefecture aPrefecture, City aCity, Aza anAza, KoAza aKoAza) {
        addressCode = anAddressCode;
        prefecture = aPrefecture;
        city = aCity;
        koAza = aKoAza;
        aza = anAza;
    }

    public static AddressInformation of(AddressCode anAddressCode, Prefecture aPrefecture, City aCity, Aza anAza, KoAza aKoAza) {
        return new AddressInformation(anAddressCode, aPrefecture, aCity, anAza, aKoAza);

    }

    @Override
    public boolean sameValueAs(AddressInformation other) {
        if (isNull(other))
            return false;

        return equal(addressCode, other.addressCode) &&
                equal(prefecture, other.prefecture) &&
                equal(city, other.city) &&
                equal(aza, other.aza) &&
                equal(koAza, other.koAza);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressInformation that = (AddressInformation) o;
        return sameValueAs(that);

    }

    @Override
    public int hashCode() {
        return hash(addressCode, prefecture, city, koAza, aza);

    }
}
