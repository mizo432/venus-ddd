package org.venuspj.basic.model.domain.relashonshipManagement.party.person;

import org.venuspj.basic.model.domain.relashonshipManagement.party.Party;
import org.venuspj.basic.model.domain.relashonshipManagement.party.PartyIdentifier;

public abstract class Person<
        P extends Person<P, I, PI>,
        I extends PartyIdentifier<I>,
        PI extends PersonInformation<PI>>
        extends Party<P, I, PI> {

    protected Person(I anIdentifier, PI aPersonInformation) {
        super(anIdentifier, aPersonInformation);

    }

    protected Person(I anIdentifier) {
        super(anIdentifier);

    }

    protected PI getPersonInformation() {
        return partyInformation();

    }

    protected static abstract class PersonBuilder<
            E extends Person<E, EI, PI>,
            EI extends PartyIdentifier<EI>,
            PI extends PersonInformation<PI>,
            B extends PersonBuilder<E, EI, PI, B>>
            extends Party.PartyBuilder<E, EI, PI, B> {

        @Override
        protected void apply(E vo, B builder) {
            super.apply(vo, builder);
            builder.withPersonInformation(vo.getPersonInformation());
            
        }

        protected B withPersonInformation(PI aPersonInformation) {
            return super.withPartyInformation(aPersonInformation);

        }

    }

}
