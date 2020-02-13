package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.name.Name;
import org.venuspj.util.builder.ObjectBuilder;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.*;

public class CityInformation implements Value<CityInformation> {
    private CityCode cityCode = CityCode.empty();
    private Name name = Name.empty();

    public CityInformation(CityCode aCityCode, Name aName) {
        name = aName;
        cityCode = aCityCode;
    }

    public CityInformation() {

    }

    public Name getName() {
        return name;
    }

    public static CityInformation empty() {
        return new CityInformation();

    }

    public static CityInformation of(CityCode aCityCode, Name aName) {
        return new CityInformation(aCityCode, aName);

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
        return equal(name, that.name)
                && equal(cityCode, cityCode);

    }

    @Override
    public int hashCode() {
        return Objects2.hash(cityCode, name);

    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return name.isEmpty()
                && cityCode.isEmpty();

    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();
    }

    public static CityInformationBuilder builder() {
        return new CityInformationBuilder();
    }

    public CityCode getCityCode() {
        return cityCode;

    }

    public void setCityCode(CityCode cityCode) {
        this.cityCode = cityCode;
    }

    public static class CityInformationBuilder extends ObjectBuilder<CityInformation, CityInformationBuilder> {
        private CityCode cityCode = CityCode.empty();
        private Name name = Name.empty();

        @Override
        protected void apply(CityInformation vo, CityInformationBuilder builder) {
            builder.cityCode = vo.getCityCode();
            builder.name = vo.getName();

        }

        @Override
        protected CityInformation createValueObject() {
            return new CityInformation(cityCode, name);

        }

        @Override
        protected CityInformationBuilder getThis() {
            return this;

        }

        @Override
        protected CityInformationBuilder newInstance() {
            return new CityInformationBuilder();

        }

        public CityInformationBuilder withCityCode(CityCode aCityCode) {
            if (isNull(aCityCode)) return getThis();
            addConfigurator(builder -> builder.cityCode = aCityCode);
            return getThis();

        }

        public CityInformationBuilder withName(Name aName) {
            if (isNull(aName)) return getThis();
            addConfigurator(builder -> builder.name = aName);
            return getThis();
        }
    }
}
