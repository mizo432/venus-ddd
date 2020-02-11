package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.ddd.model.values.buisiness.Name;
import org.venuspj.util.builder.ObjectBuilder;

import static org.venuspj.util.objects2.Objects2.isNull;


public class PrefectureInformation extends AbstractValue<PrefectureInformation> {
    private PrefectureCode prefectureCode = PrefectureCode.empty();
    private Name name = Name.empty();
    private Name kanaName = Name.empty();
    private CityIdentifiers cityIdentifiers = CityIdentifiers.empty();

    protected PrefectureInformation(PrefectureCode aPrefectureCode, Name aName, Name aKanaName, CityIdentifiers anyCityIdentifiers) {
        prefectureCode = aPrefectureCode;
        name = aName;
        kanaName = aKanaName;
        cityIdentifiers = anyCityIdentifiers;

    }

    public PrefectureInformation() {

    }

    public static PrefectureInformation empty() {
        return new PrefectureInformation();
    }


    @Override
    public boolean sameValueAs(PrefectureInformation other) {
        return equals(other);
    }

    @Override
    public boolean isEmpty() {
        return prefectureCode.isEmpty() &&
                name.isEmpty() &&
                kanaName.isEmpty() &&
                cityIdentifiers.isEmpty();
    }

    public static PrefectureInformationBuilder builder() {
        return new PrefectureInformationBuilder();

    }

    public static class PrefectureInformationBuilder extends ObjectBuilder<PrefectureInformation, PrefectureInformationBuilder> {
        protected PrefectureCode prefectureCode = PrefectureCode.empty();
        protected Name name = Name.empty();
        protected Name kanaName = Name.empty();
        protected CityIdentifiers cityIdentifiers = CityIdentifiers.empty();

        @Override
        public void apply(PrefectureInformation vo, PrefectureInformationBuilder builder) {
            builder.withPrefectureCode(vo.prefectureCode());
            builder.withName(vo.name());
            builder.withKanaName(vo.kanaName());
            builder.withCityIdentifiers(vo.cityIdentifiers());

        }

        public PrefectureInformationBuilder withCityIdentifiers(CityIdentifiers anYCityIdentifiers) {
            if (isNull(anYCityIdentifiers)) return getThis();
            addConfigurator(builder -> builder.cityIdentifiers = anYCityIdentifiers);
            return getThis();

        }

        public PrefectureInformationBuilder withKanaName(Name aKanaName) {
            if (isNull(aKanaName)) return getThis();
            addConfigurator(builder -> builder.kanaName = aKanaName);
            return getThis();


        }

        public PrefectureInformationBuilder withName(Name aName) {
            if (isNull(aName)) return getThis();
            addConfigurator(builder -> builder.name = aName);
            return getThis();

        }

        public PrefectureInformationBuilder withPrefectureCode(PrefectureCode aPrefectureCode) {
            if (isNull(aPrefectureCode)) return getThis();
            addConfigurator(builder -> builder.prefectureCode = aPrefectureCode);
            return getThis();

        }

        @Override
        protected PrefectureInformation createValueObject() {
            return new PrefectureInformation(prefectureCode, name, kanaName, cityIdentifiers);

        }

        @Override
        protected PrefectureInformationBuilder getThis() {
            return getThis();
        }

        @Override
        protected PrefectureInformationBuilder newInstance() {
            return new PrefectureInformationBuilder();
        }
    }

    private CityIdentifiers cityIdentifiers() {
        return cityIdentifiers;

    }

    private Name kanaName() {
        return kanaName;

    }

    private Name name() {
        return name;

    }

    private PrefectureCode prefectureCode() {
        return prefectureCode;

    }

}
