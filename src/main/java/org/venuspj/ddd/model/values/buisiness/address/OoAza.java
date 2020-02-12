package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.buisiness.Name;

public class OoAza extends AbstractOoAza<OoAza> {

    OoAza(OoAzaIdentifier aaOoAzaIdentifier, OoAzaCode anOoAzaCode,
          Name aName,
          Name aKanaName) {
        super(aaOoAzaIdentifier, anOoAzaCode, aName, aKanaName);

    }

    public OoAza() {
        super();

    }

    public static OoAza empty() {
        return new OoAza();

    }

    public static OoAza of(OoAzaIdentifier aOoAzaIdentifier, OoAzaCode anOoAzaCode,
                           Name aName,
                           Name aKanaName) {
        return new OoAza(aOoAzaIdentifier, anOoAzaCode, aName, aKanaName);

    }

    public static class OoAzaBuilder
            extends AbstractOoAzaBuilder<OoAza, OoAzaBuilder> {


        @Override
        protected void apply(OoAza vo, OoAzaBuilder builder) {
            super.apply(vo, builder);

        }

        @Override
        protected OoAza createValueObject() {
            return new OoAza(identifier,
                    ooAzaCode,
                    name,
                    kanaName);
        }

        @Override
        protected OoAzaBuilder getThis() {
            return this;
        }

        @Override
        protected OoAzaBuilder newInstance() {
            return new OoAzaBuilder();
        }
    }

}
