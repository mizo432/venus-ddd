package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.buisiness.name.Name;

public class Aza extends AbstractAza<Aza> {

    Aza(AzaIdentifier anAzaIdentifier, AzaCode anAzaCode, Name aName, Name aKanaName) {
        super(anAzaIdentifier, anAzaCode, aName, aKanaName);

    }

    public Aza() {
        super();
    }

    public static Aza empty() {
        return new Aza();

    }

    public static Aza of(AzaIdentifier anAzaIdentifier, AzaCode anAzaCode, Name aName, Name aKanaName) {
        return new Aza(anAzaIdentifier, anAzaCode, aName, aKanaName);

    }

    public static AzaBuilder builder() {
        return new AzaBuilder();
    }

    public static class AzaBuilder extends AbstractAzaBuilder<Aza, AzaBuilder> {

        @Override
        protected Aza createValueObject() {
            return new Aza(super.identifier, super.azaCode, super.name, super.kanaName);
        }

        @Override
        protected AzaBuilder getThis() {
            return this;
        }

        @Override
        protected AzaBuilder newInstance() {
            return new AzaBuilder();
        }
    }

}
