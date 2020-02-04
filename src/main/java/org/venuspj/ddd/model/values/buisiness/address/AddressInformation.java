package org.venuspj.ddd.model.values.buisiness.address;


import org.venuspj.ddd.model.values.Value;

import static org.venuspj.util.objects2.Objects2.*;

public class AddressInformation implements Value<AddressInformation> {
    private AddressCode addressCode;
    private Prefecture prefecture;
    private City city;
    private KoAza koAza;
    private Aza aza;
    private AddressPostfix addressPostfix;

    AddressInformation(AddressCode anAddressCode, Prefecture aPrefecture, City aCity, Aza anAza, KoAza aKoAza, AddressPostfix anAddressPostfix) {
        addressCode = anAddressCode;
        prefecture = aPrefecture;
        city = aCity;
        koAza = aKoAza;
        aza = anAza;
        addressPostfix = anAddressPostfix;
    }

    public AddressInformation() {
        addressCode = AddressCode.empty();
        prefecture = Prefecture.EMPTY;
        city = City.empty();
        koAza = KoAza.empty();
        aza = Aza.empty();
        addressPostfix = AddressPostfix.empty();

    }

    public static AddressInformation of(AddressCode anAddressCode, Prefecture aPrefecture, City aCity, Aza anAza, KoAza aKoAza, AddressPostfix anAddressPostfix) {
        return new AddressInformation(anAddressCode, aPrefecture, aCity, anAza, aKoAza, anAddressPostfix);

    }

    public static AddressInformation of(AddressCode anAddressCode, Prefecture aPrefecture, City aCity, Aza anAza, KoAza aKoAza) {
        return new AddressInformation(anAddressCode, aPrefecture, aCity, anAza, aKoAza, AddressPostfix.empty());

    }

    public static AddressInformation empty() {
        return new AddressInformation();
    }

    @Override
    public boolean sameValueAs(AddressInformation other) {
        if (isNull(other))
            return false;

        return equal(addressCode, other.addressCode) &&
                equal(prefecture, other.prefecture) &&
                equal(city, other.city) &&
                equal(aza, other.aza) &&
                equal(koAza, other.koAza) &&
                equal(addressPostfix, other.addressPostfix);

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
        return hash(addressCode, prefecture, city, koAza, aza, addressPostfix);

    }

    public boolean isEmpty() {
        return addressCode.isEmpty()
                && prefecture.EMPTY.isEmpty()
                && city.isEmpty()
                && koAza.isEmpty()
                && aza.isEmpty()
                && addressPostfix.isEmpty();

    }
}
