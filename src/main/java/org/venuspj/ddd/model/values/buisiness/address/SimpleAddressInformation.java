package org.venuspj.ddd.model.values.buisiness.address;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.util.builder.ObjectBuilder;

import static org.venuspj.util.objects2.Objects2.*;

public class SimpleAddressInformation extends AbstractValue<SimpleAddressInformation> {
    protected ZipCode zipCode = ZipCode.empty();
    protected AddressCode addressCode = AddressCode.empty();
    protected Prefecture prefecture = Prefecture.empty();
    protected City city = City.empty();
    protected OoAza ooAza = OoAza.empty();
    protected Aza koAza = Aza.empty();
    protected AddressBarCode addressBarCode = AddressBarCode.empty();

    SimpleAddressInformation(ZipCode aZipCode, AddressCode anAddressCode, Prefecture aPrefecture, City aCity, OoAza anOoAza, Aza anAza, AddressBarCode anAddressBarCode) {
        zipCode = aZipCode;
        addressCode = anAddressCode;
        prefecture = aPrefecture;
        city = aCity;
        koAza = anAza;
        ooAza = anOoAza;
        addressBarCode = anAddressBarCode;

    }

    public SimpleAddressInformation() {

    }

    public ZipCode zipCode() {
        return zipCode;

    }

    public AddressCode addressCode() {
        return addressCode;

    }

    public Prefecture prefecture() {
        return prefecture;

    }

    public City city() {
        return city;

    }

    public OoAza ooAza() {
        return ooAza;

    }

    public Aza koAza() {
        return koAza;

    }

    private AddressBarCode addressBarCode() {
        return addressBarCode;

    }

    public static SimpleAddressInformation of(ZipCode aZipCode, AddressCode anAddressCode, Prefecture aPrefecture, City aCity, OoAza anOoAza, Aza anAza, AddressBarCode anAddressBarCode) {
        return new SimpleAddressInformation(aZipCode, anAddressCode, aPrefecture, aCity, anOoAza, anAza, anAddressBarCode);

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
        return equal(zipCode, that.zipCode) &&
                equal(addressCode, that.addressCode) &&
                equal(prefecture, that.prefecture) &&
                equal(city, that.city) &&
                equal(ooAza, that.ooAza) &&
                equal(koAza, that.koAza) &&
                equal(addressBarCode, addressBarCode);
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
        protected Prefecture prefecture = Prefecture.empty();
        protected City city = City.empty();
        protected OoAza ooAza = OoAza.empty();
        protected Aza koAza = Aza.empty();
        protected AddressBarCode addressBarCode = AddressBarCode.empty();


        @Override
        protected void apply(SimpleAddressInformation vo, SimpleAddressInformationBuilder builder) {
            builder.withPostalCode(vo.zipCode());
            builder.withAddressCode(vo.addressCode());
            builder.withPrefecture(vo.prefecture());
            builder.withCity(vo.city());
            builder.withAza(vo.ooAza());
            builder.withKoAza(vo.koAza());
            builder.withAddressBarCode(vo.addressBarCode());

        }

        private SimpleAddressInformationBuilder withAddressBarCode(AddressBarCode anAddressBarCode) {
            if (isNull(anAddressBarCode)) return getThis();
            addConfigurator(builder -> builder.addressBarCode = anAddressBarCode);
            return getThis();

        }

        public SimpleAddressInformationBuilder withKoAza(Aza anAza) {
            if (isNull(anAza)) return getThis();
            addConfigurator(builder -> builder.koAza = anAza);
            return getThis();

        }

        public SimpleAddressInformationBuilder withAza(OoAza anOoAza) {
            if (isNull(anOoAza)) return getThis();
            addConfigurator(builder -> builder.ooAza = anOoAza);
            return getThis();
        }

        public SimpleAddressInformationBuilder withCity(City aCity) {
            if (isNull(aCity)) return getThis();
            addConfigurator(builder -> builder.city = aCity);
            return getThis();
        }

        protected SimpleAddressInformationBuilder withPrefecture(Prefecture aPrefecture) {
            if (isNull(aPrefecture)) return getThis();
            addConfigurator(builder -> builder.prefecture = aPrefecture);
            return getThis();
        }

        protected SimpleAddressInformationBuilder withAddressCode(AddressCode anAddressCode) {
            if (isNull(anAddressCode)) return getThis();
            addConfigurator(builder -> builder.addressCode = anAddressCode);
            return getThis();
        }

        protected SimpleAddressInformationBuilder withPostalCode(ZipCode aZipCode) {
            if (isNull(aZipCode)) return getThis();
            addConfigurator(builder -> builder.zipCode = aZipCode);
            return getThis();
        }

        @Override
        protected SimpleAddressInformation createValueObject() {
            return new SimpleAddressInformation(zipCode, addressCode, prefecture, city, ooAza, koAza, addressBarCode);

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
