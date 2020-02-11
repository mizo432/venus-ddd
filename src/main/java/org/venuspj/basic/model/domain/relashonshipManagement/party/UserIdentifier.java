package org.venuspj.basic.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public class UserIdentifier extends AbstractEntityLongIdentifier<UserIdentifier> {

    public UserIdentifier() {
        super(User.class);
    }

    public UserIdentifier(Long aValue) {
        super(User.class, aValue);
    }

    public static UserIdentifier empty() {
        return new UserIdentifier();
    }

    @Override
    public boolean sameValueAs(UserIdentifier other) {
        return equals(other);
    }
}
