package org.venuspj.ddd.model.values.buisiness.address;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.util.builder.ObjectBuilder;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.*;

public class SimpleAddressInformation implements Value<SimpleAddressInformation> {
    protected ZipCode zipCode = ZipCode.empty();
    protected AddressCode addressCode = AddressCode.empty();
    protected Prefecture prefecture = Prefecture.EMPTY;
    protected City city = City.empty();
    protected OoAza ooAza = OoAza.empty();
    protected Aza koAza = Aza.empty();

    SimpleAddressInformation(ZipCode aZipCode, AddressCode anAddressCode, Prefecture aPrefecture, City aCity, OoAza anOoAza, Aza aAza) {
        zipCode = aZipCode;
        addressCode = anAddressCode;
        prefecture = aPrefecture;
        city = aCity;
        koAza = aAza;
        ooAza = anOoAza;
    }

    public SimpleAddressInformation() {

    }

    public ZipCode getZipCode() {
        return zipCode;
    }

    public AddressCode getAddressCode() {
        return addressCode;
    }

    public Prefecture getPrefecture() {
        return prefecture;
    }

    public City getCity() {
        return city;
    }

    public OoAza getOoAza() {
        return ooAza;
    }

    public Aza getKoAza() {
        return koAza;
    }

    public static SimpleAddressInformation of(ZipCode aZipCode, AddressCode anAddressCode, Prefecture aPrefecture, City aCity, OoAza anOoAza, Aza aAza) {
        return new SimpleAddressInformation(aZipCode, anAddressCode, aPrefecture, aCity, anOoAza, aAza);

    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();

    }

    public static SimpleAddressInformation empty() {
        return new SimpleAddressInformation();

    }

    public static SimpleAddressInformationBuilder builder() {
        return new SimpleAddressInformationBuilder();

    }

    @Override
    public boolean sameValueAs(SimpleAddressInformation other) {
        return equals(other);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleAddressInformation that = (SimpleAddressInformation) o;
        return Objects2.equal(zipCode, that.zipCode) &&
                Objects2.equal(addressCode, that.addressCode) &&
                prefecture == that.prefecture &&
                Objects2.equal(city, that.city) &&
                Objects2.equal(ooAza, that.ooAza) &&
                Objects2.equal(koAza, that.koAza);
    }

    @Override
    public int hashCode() {
        return hash(zipCode, addressCode, prefecture, city, koAza, ooAza);

    }

    @JsonIgnore
    public boolean isEmpty() {
        return zipCode.isEmpty()
                && addressCode.isEmpty()
                && prefecture.isEmpty()
                && city.isEmpty()
                && koAza.isEmpty()
                && ooAza.isEmpty();

    }

    public static class SimpleAddressInformationBuilder extends ObjectBuilder<SimpleAddressInformation, SimpleAddressInformationBuilder> {
        protected ZipCode zipCode = ZipCode.empty();
        protected AddressCode addressCode = AddressCode.empty();
        protected Prefecture prefecture = Prefecture.EMPTY;
        protected City city = City.empty();
        protected OoAza ooAza = OoAza.empty();
        protected Aza koAza = Aza.empty();


        @Override
        protected void apply(SimpleAddressInformation vo, SimpleAddressInformationBuilder builder) {
            builder.withPostalCode(vo.zipCode);
            builder.withAddressCode(vo.addressCode);
            builder.withPrefecture(vo.prefecture);
            builder.withCity(vo.city);
            builder.withAza(vo.ooAza);
            builder.withKoAza(vo.koAza);

        }

        public SimpleAddressInformationBuilder withKoAza(Aza anAza) {
            if (isNull(anAza)) return getThis();
            addConfigurator(builder -> builder.koAza = anAza);
            return getThis();
        }

        public SimpleAddressInformationBuilder withAza(OoAza ooAza) {
            if (isNull(ooAza)) return getThis();
            addConfigurator(builder -> builder.ooAza = ooAza);
            return getThis();
        }

        public SimpleAddressInformationBuilder withCity(City city) {
            if (isNull(city)) return getThis();
            addConfigurator(builder -> builder.city = city);
            return getThis();
        }

        protected SimpleAddressInformationBuilder withPrefecture(Prefecture aPrefecture) {
            if (isNull(aPrefecture)) return getThis();
            addConfigurator(builder -> builder.prefecture = aPrefecture);
            return getThis();
        }

        protected SimpleAddressInformationBuilder withAddressCode(AddressCode aAddressCode) {
            if (isNull(aAddressCode)) return getThis();
            addConfigurator(builder -> builder.addressCode = aAddressCode);
            return getThis();
        }

        protected SimpleAddressInformationBuilder withPostalCode(ZipCode aZipCode) {
            if (isNull(aZipCode)) return getThis();
            addConfigurator(builder -> builder.zipCode = aZipCode);
            return getThis();
        }

        @Override
        protected SimpleAddressInformation createValueObject() {
            return new SimpleAddressInformation(zipCode, addressCode, prefecture, city, ooAza, koAza);

        }

        @Override
        protected SimpleAddressInformationBuilder getThis() {
            return this;
        }

        @Override
        protected SimpleAddressInformationBuilder newInstance() {
            return new SimpleAddressInformationBuilder();
        }
    }
}
