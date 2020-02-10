package org.venuspj.basic.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.values.AbstractValue;

/**
 * 利用者の状態
 */
public class UserStatics extends AbstractValue<UserStatics> {

    @Override
    public boolean sameValueAs(UserStatics other) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return true;

    }
}
