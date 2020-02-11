package org.venuspj.basic.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.entity.AbstractEntity;

/**
 * 人または組織の利用者
 */
public class User extends AbstractEntity<User, UserIdentifier> {

    protected User(UserIdentifier anIdentifier) {
        super(anIdentifier);
    }

    protected User() {
        super(UserIdentifier.empty());
    }
}
