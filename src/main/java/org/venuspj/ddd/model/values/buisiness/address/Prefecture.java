package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.buisiness.Name;


public class Prefecture extends AbstractPrefecture<Prefecture> {

    public Prefecture() {
        super();

    }

    protected Prefecture(PrefectureIdentifier anIdentifier,
                         PrefectureCode aPrefectureCode,
                         Name aName,
                         Name aKanaName) {
        super(anIdentifier,
                aPrefectureCode,
                aName,
                aKanaName);

    }

    public static Prefecture empty() {
        return new Prefecture();

    }

    public static PrefectureBuilder builder() {
        return new PrefectureBuilder();
    }

    public static class PrefectureBuilder

            extends AbstractPrefectureBuilder<Prefecture, PrefectureBuilder> {


        @Override
        protected void apply(Prefecture vo, PrefectureBuilder builder) {
            builder.withIdentifier(vo.getIdentifier());
            builder.withCityCode(vo.prefectureCode());
            builder.withName(vo.name());
            builder.withKanaName(vo.kanaName());


        }

        @Override
        protected Prefecture createValueObject() {
            return new Prefecture(identifier,
                    prefectureCode,
                    name,
                    kanaName);
        }

        @Override
        protected PrefectureBuilder getThis() {
            return this;
        }

        @Override
        protected PrefectureBuilder newInstance() {
            return new PrefectureBuilder();
        }
    }


}
