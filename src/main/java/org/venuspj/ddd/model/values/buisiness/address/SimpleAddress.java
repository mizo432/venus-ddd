package org.venuspj.ddd.model.values.buisiness.address;


import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.util.builder.ObjectBuilder;

import static org.venuspj.util.objects2.Objects2.*;

public class SimpleAddress extends AbstractValue<SimpleAddress> {
    protected ZipCode zipCode = ZipCode.empty();
    protected AddressCode addressCode = AddressCode.empty();
    protected Prefecture prefecture = Prefecture.empty();
    protected City city = City.empty();
    protected OoAza ooAza = OoAza.empty();
    protected Aza koAza = Aza.empty();
    protected AddressBarCode addressBarCode = AddressBarCode.empty();

    SimpleAddress(ZipCode aZipCode, AddressCode anAddressCode, Prefecture aPrefecture, City aCity, OoAza anOoAza, Aza anAza, AddressBarCode anAddressBarCode) {
        zipCode = aZipCode;
        addressCode = anAddressCode;
        prefecture = aPrefecture;
        city = aCity;
        koAza = anAza;
        ooAza = anOoAza;
        addressBarCode = anAddressBarCode;

    }

    public SimpleAddress() {

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

    public static SimpleAddress of(ZipCode aZipCode, AddressCode anAddressCode, Prefecture aPrefecture, City aCity, OoAza anOoAza, Aza anAza, AddressBarCode anAddressBarCode) {
        return new SimpleAddress(aZipCode, anAddressCode, aPrefecture, aCity, anOoAza, anAza, anAddressBarCode);

    }

    public static SimpleAddress empty() {
        return new SimpleAddress();

    }

    public static SimpleAddressInformationBuilder builder() {
        return new SimpleAddressInformationBuilder();

    }

    @Override
    public boolean sameValueAs(SimpleAddress other) {
        return equals(other);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleAddress that = (SimpleAddress) o;
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

    public boolean isEmpty() {
        return zipCode.isEmpty()
                && addressCode.isEmpty()
                && prefecture.isEmpty()
                && city.isEmpty()
                && koAza.isEmpty()
                && ooAza.isEmpty();

    }

    public static class SimpleAddressInformationBuilder extends ObjectBuilder<SimpleAddress, SimpleAddressInformationBuilder> {
        protected ZipCode zipCode = ZipCode.empty();
        protected AddressCode addressCode = AddressCode.empty();
        protected Prefecture prefecture = Prefecture.empty();
        protected City city = City.empty();
        protected OoAza ooAza = OoAza.empty();
        protected Aza koAza = Aza.empty();
        protected AddressBarCode addressBarCode = AddressBarCode.empty();


        @Override
        protected void apply(SimpleAddress vo, SimpleAddressInformationBuilder builder) {
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
        protected SimpleAddress createValueObject() {
            return new SimpleAddress(zipCode, addressCode, prefecture, city, ooAza, koAza, addressBarCode);

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
