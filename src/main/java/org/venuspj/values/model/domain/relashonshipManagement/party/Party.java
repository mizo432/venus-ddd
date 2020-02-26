package org.venuspj.values.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.entity.AbstractEntityBuilder;

import static org.venuspj.util.objects2.Objects2.isNull;

public abstract class Party<P extends Party<P, I, PI>, I extends PartyIdentifier<I>, PI extends PartyInformation<PI>> extends AbstractEntity<P, I> {
    private PI partyInformation;

    protected Party(I anIdentifier) {
        super(anIdentifier);

    }

    protected Party(I anIdentifier, PI aPartyInformation) {
        super(anIdentifier);
        partyInformation = aPartyInformation;

    }

    protected PI partyInformation() {
        return partyInformation;
    }


    public static abstract class PartyBuilder<
            E extends Party<E, EI, PIF>,
            EI extends PartyIdentifier<EI>,
            PIF extends PartyInformation<PIF>,
            B extends PartyBuilder<E, EI, PIF, B>>
            extends AbstractEntityBuilder<E, EI, B> {

        protected PIF partyInformation;

        @Override
        protected void apply(E vo, B builder) {
            super.apply(vo, builder);
            builder.withPartyInformation(vo.partyInformation());

        }

        protected B withPartyInformation(PIF aPartyInformation) {
            if (isNull(aPartyInformation)) return getThis();
            addConfigurator(builder -> builder.partyInformation = aPartyInformation);
            return getThis();

        }

    }
}
