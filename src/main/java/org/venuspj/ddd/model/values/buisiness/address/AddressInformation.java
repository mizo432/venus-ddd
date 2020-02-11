package org.venuspj.ddd.model.values.buisiness.address;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.util.builder.ObjectBuilder;

import static org.venuspj.util.objects2.Objects2.*;

public class AddressInformation extends AbstractValue<AddressInformation> {
    private SimpleAddressInformation simpleAddressInformation = SimpleAddressInformation.empty();
    private AddressPostfix addressPostfix = AddressPostfix.empty();

    AddressInformation(SimpleAddressInformation aSimpleAddressInformation, AddressPostfix anAddressPostfix) {
        simpleAddressInformation = aSimpleAddressInformation;
        addressPostfix = anAddressPostfix;
    }

    public AddressInformation() {

    }

    public SimpleAddressInformation getSimpleAddressInformation() {
        return simpleAddressInformation;
    }

    public AddressPostfix getAddressPostfix() {
        return addressPostfix;
    }

    public static AddressInformation of(ZipCode aZipCode, AddressCode anAddressCode, Prefecture aPrefecture, City aCity, OoAza anOoAza, Aza aAza, AddressPostfix anAddressPostfix) {
        return of(
                SimpleAddressInformation
                        .builder()
                        .withPostalCode(aZipCode)
                        .withAddressCode(anAddressCode)
                        .withPrefecture(aPrefecture)
                        .withCity(aCity)
                        .withAza(anOoAza)
                        .withKoAza(aAza)
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
        return equal(simpleAddressInformation, that.simpleAddressInformation) &&
                equal(addressPostfix, that.addressPostfix);
    }

    @Override
    public int hashCode() {
        return hash(simpleAddressInformation, addressPostfix);
    }

    @JsonIgnore
    public boolean isEmpty() {
        return simpleAddressInformation.isEmpty()
                && addressPostfix.isEmpty();

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
