package org.venuspj.ddd.model.values.buisiness.address;


import org.venuspj.ddd.model.values.Value;
import org.venuspj.util.builder.ObjectBuilder;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.isNull;
import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class AddressInformation implements Value<AddressInformation> {
    private SimpleAddressInformation simpleAddressInformation = SimpleAddressInformation.empty();
    private AddressPostfix addressPostfix = AddressPostfix.empty();

    AddressInformation(SimpleAddressInformation aSimpleAddressInformation, AddressPostfix anAddressPostfix) {
        simpleAddressInformation = aSimpleAddressInformation;
        addressPostfix = anAddressPostfix;
    }

    public AddressInformation() {

    }

    public static AddressInformation of(PostalCode aPostalCode, AddressCode anAddressCode, Prefecture aPrefecture, City aCity, Aza anAza, KoAza aKoAza, AddressPostfix anAddressPostfix) {
        return of(
                SimpleAddressInformation
                        .builder()
                        .withPostalCode(aPostalCode)
                        .withAddressCode(anAddressCode)
                        .withPrefecture(aPrefecture)
                        .withCity(aCity)
                        .withAza(anAza)
                        .withKoAza(aKoAza)
                        .build(), anAddressPostfix);

    }

    public static AddressInformation of(SimpleAddressInformation aSimpleAddressInformation, AddressPostfix anAddressPostfix) {
        return new AddressInformation(aSimpleAddressInformation, anAddressPostfix);

    }

    public static AddressInformation empty() {
        return new AddressInformation();

    }

    public boolean sameValueAs(AddressInformation other) {
        return equals(other);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressInformation that = (AddressInformation) o;
        return Objects2.equal(simpleAddressInformation, that.simpleAddressInformation) &&
                Objects2.equal(addressPostfix, that.addressPostfix);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(simpleAddressInformation, addressPostfix);
    }

    public boolean isEmpty() {
        return simpleAddressInformation.isEmpty()
                && addressPostfix.isEmpty();

    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();

    }

    public static AddressInformationBuilder builder() {
        return new AddressInformationBuilder();
    }

    public static class AddressInformationBuilder extends ObjectBuilder<AddressInformation, AddressInformationBuilder> {

        private SimpleAddressInformation simpleAddressInformation = SimpleAddressInformation.empty();
        private AddressPostfix addressPostfix = AddressPostfix.empty();


        @Override
        protected void apply(AddressInformation vo, AddressInformationBuilder builder) {
            builder.withSimpleAddressInformation(vo.simpleAddressInformation);
            builder.withAddressPostfix(vo.addressPostfix);


        }

        public AddressInformationBuilder withAddressPostfix(AddressPostfix anAddressPostfix) {
            if (isNull(anAddressPostfix)) return getThis();
            addConfigurator(builder -> builder.addressPostfix = anAddressPostfix);
            return getThis();
        }

        public AddressInformationBuilder withSimpleAddressInformation(SimpleAddressInformation aSimpleAddressInformation) {
            if (isNull(aSimpleAddressInformation)) return getThis();
            addConfigurator(builder -> builder.simpleAddressInformation = aSimpleAddressInformation);
            return getThis();
        }

        @Override
        protected AddressInformation createValueObject() {
            return new AddressInformation(simpleAddressInformation, addressPostfix);
        }

        @Override
        protected AddressInformationBuilder getThis() {
            return this;
        }

        @Override
        protected AddressInformationBuilder newInstance() {
            return new AddressInformationBuilder();
        }
    }
}
