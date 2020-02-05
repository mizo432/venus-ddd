package org.venuspj.ddd.model.values.buisiness.address;


import org.venuspj.ddd.model.values.Value;
import org.venuspj.util.builder.ObjectBuilder;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.*;

public class SimpleAddressInformation implements Value<SimpleAddressInformation> {
    protected PostalCode postalCode = PostalCode.empty();
    protected AddressCode addressCode = AddressCode.empty();
    protected Prefecture prefecture = Prefecture.EMPTY;
    protected City city = City.empty();
    protected Aza aza = Aza.empty();
    protected KoAza koAza = KoAza.empty();

    SimpleAddressInformation(PostalCode aPostalCode, AddressCode anAddressCode, Prefecture aPrefecture, City aCity, Aza anAza, KoAza aKoAza) {
        postalCode = aPostalCode;
        addressCode = anAddressCode;
        prefecture = aPrefecture;
        city = aCity;
        koAza = aKoAza;
        aza = anAza;
    }

    public SimpleAddressInformation() {

    }

    public static SimpleAddressInformation of(PostalCode aPostalCode, AddressCode anAddressCode, Prefecture aPrefecture, City aCity, Aza anAza, KoAza aKoAza) {
        return new SimpleAddressInformation(aPostalCode, anAddressCode, aPrefecture, aCity, anAza, aKoAza);

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
        return Objects2.equal(postalCode, that.postalCode) &&
                Objects2.equal(addressCode, that.addressCode) &&
                prefecture == that.prefecture &&
                Objects2.equal(city, that.city) &&
                Objects2.equal(aza, that.aza) &&
                Objects2.equal(koAza, that.koAza);
    }

    @Override
    public int hashCode() {
        return hash(postalCode, addressCode, prefecture, city, koAza, aza);

    }

    public boolean isEmpty() {
        return postalCode.isEmpty()
                && addressCode.isEmpty()
                && prefecture.isEmpty()
                && city.isEmpty()
                && koAza.isEmpty()
                && aza.isEmpty();

    }

    public static class SimpleAddressInformationBuilder extends ObjectBuilder<SimpleAddressInformation, SimpleAddressInformationBuilder> {
        protected PostalCode postalCode = PostalCode.empty();
        protected AddressCode addressCode = AddressCode.empty();
        protected Prefecture prefecture = Prefecture.EMPTY;
        protected City city = City.empty();
        protected Aza aza = Aza.empty();
        protected KoAza koAza = KoAza.empty();


        @Override
        protected void apply(SimpleAddressInformation vo, SimpleAddressInformationBuilder builder) {
            builder.withPostalCode(vo.postalCode);
            builder.withAddressCode(vo.addressCode);
            builder.withPrefecture(vo.prefecture);
            builder.withCity(vo.city);
            builder.withAza(vo.aza);
            builder.withKoAza(vo.koAza);

        }

        public SimpleAddressInformationBuilder withKoAza(KoAza koAza) {
            if (isNull(koAza)) return getThis();
            addConfigurator(builder -> builder.koAza = koAza);
            return getThis();
        }

        public SimpleAddressInformationBuilder withAza(Aza aza) {
            if (isNull(aza)) return getThis();
            addConfigurator(builder -> builder.aza = aza);
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

        protected SimpleAddressInformationBuilder withPostalCode(PostalCode aPostalCode) {
            if (isNull(aPostalCode)) return getThis();
            addConfigurator(builder -> builder.postalCode = aPostalCode);
            return getThis();
        }

        @Override
        protected SimpleAddressInformation createValueObject() {
            return new SimpleAddressInformation(postalCode, addressCode, prefecture, city, aza, koAza);

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