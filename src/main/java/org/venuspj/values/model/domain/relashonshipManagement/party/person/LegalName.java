package org.venuspj.values.model.domain.relashonshipManagement.party.person;

import org.venuspj.ddd.model.values.primitives.AbstractStringValue;

public class LegalName extends AbstractStringValue<LegalName> {

    public static LegalName empty() {
        return new LegalName();

    }
}
