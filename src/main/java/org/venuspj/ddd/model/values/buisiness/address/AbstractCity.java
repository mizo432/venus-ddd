package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.entity.AbstractEntityBuilder;
import org.venuspj.ddd.model.values.buisiness.name.Name;

import static org.venuspj.util.objects2.Objects2.isNull;

public class AbstractCity<C extends AbstractCity<C>> extends AbstractEntity<C, CityIdentifier> {

    public CityCode cityCode() {
        return cityCode;
    }

    public Name name() {
        return name;
    }

    public Name kanaName() {
        return kanaName;
    }

    private CityCode cityCode = CityCode.empty();
    private Name name = Name.empty();
    private Name kanaName = Name.empty();


    public AbstractCity() {
        super(CityIdentifier.empty());

    }

    protected AbstractCity(CityIdentifier aCityIdentifier, CityCode aCityCode,
                           Name aName,
                           Name aKanaName) {
        super(aCityIdentifier);
        cityCode = aCityCode;
        name = aKanaName;
        kanaName = aKanaName;

    }

    /**
     * @param <O>
     * @param <B>
     */
    public static abstract class AbstractCityBuilder
            <O extends AbstractCity<O>,
                    B extends AbstractCityBuilder<O, B>>
            extends AbstractEntityBuilder<O, CityIdentifier, B> {
        protected CityCode cityCode = CityCode.empty();
        protected Name name = Name.empty();
        protected Name kanaName = Name.empty();

        @Override
        protected void apply(O vo, B builder) {
            builder.withIdentifier(vo.getIdentifier());
            builder.withCityCode(vo.cityCode());
            builder.withName(vo.name());
            builder.withKanaName(vo.kanaName());


        }

        public B withKanaName(Name aKanaName) {
            if (isNull(aKanaName)) return getThis();
            addConfigurator(builder -> builder.kanaName = aKanaName);
            return getThis();

        }

        public B withName(Name aName) {
            if (isNull(aName)) return getThis();
            addConfigurator(builder -> builder.name = aName);
            return getThis();

        }

        public B withCityCode(CityCode aCityCode) {
            if (isNull(aCityCode)) return getThis();
            addConfigurator(builder -> builder.cityCode = aCityCode);
            return getThis();

        }

    }

}
