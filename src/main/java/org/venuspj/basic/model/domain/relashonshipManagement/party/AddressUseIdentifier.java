package org.venuspj.basic.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public class AddressUseIdentifier extends AbstractEntityLongIdentifier<AddressUseIdentifier> {

    AddressUseIdentifier(Long aValue) {
        super(AddressUseIdentifier.class, aValue);

    }

    public AddressUseIdentifier() {
        super(AddressUseIdentifier.class);

    }
}
