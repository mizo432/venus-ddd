package org.venuspj.values.model.domain.relashonshipManagement.party.organization;

import org.venuspj.values.model.domain.relashonshipManagement.party.PartyInformation;
import org.venuspj.ddd.model.values.buisiness.name.Name;

public abstract class OrganizationInformation<P extends OrganizationInformation<P>> extends PartyInformation<P> {

    private Name name = Name.empty();


}
