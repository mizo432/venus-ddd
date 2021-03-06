package org.venuspj.values.model.domain.relashonshipManagement.party;

import org.venuspj.ddd.model.values.Value;

/**
 * 人または組織の利用者情報
 */
public class UserInformation implements Value<UserInformation> {

    protected UserStaticsHistoryYear userStaticsHistory;

    public static UserInformation empty() {
        return new UserInformation();
    }

    @Override
    public boolean sameValueAs(UserInformation other) {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

}
