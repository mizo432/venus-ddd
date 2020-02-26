package org.venuspj.values.model.domain.relashonshipManagement.party.person;

import org.venuspj.values.model.domain.relashonshipManagement.party.PartyInformation;

public abstract class PersonInformation<P extends PersonInformation<P>> extends PartyInformation<P> {
    //
    protected LegalName legalName = LegalName.empty();
    protected DayOfBirth dayOfBirth = DayOfBirth.empty();

}
