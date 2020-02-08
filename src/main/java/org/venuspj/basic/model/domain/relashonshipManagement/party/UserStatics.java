package org.venuspj.basic.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.values.Value;

public class UserStatics implements Value<UserStatics> {
    @Override
    public boolean sameValueAs(UserStatics other) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }
}
