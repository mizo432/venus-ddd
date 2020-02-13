package org.venuspj.basic.model.domain.relashonshipManagement.party.organization;

import org.venuspj.basic.model.domain.relashonshipManagement.party.Party;
import org.venuspj.basic.model.domain.relashonshipManagement.party.PartyIdentifier;

public class Organization<O extends Organization<O, I, OI>, I extends PartyIdentifier<I>, OI extends OrganizationInformation<OI>> extends Party<O, I, OI> {


    protected Organization(I anIdentifier) {
        super(anIdentifier);

    }

    protected Organization(I anIdentifier, OI aOrganizationInformation) {
        super(anIdentifier, aOrganizationInformation);

    }

    protected OI organizationInformation() {
        return super.partyInformation();

    }

}
