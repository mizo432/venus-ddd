package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.buisiness.name.Name;


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
