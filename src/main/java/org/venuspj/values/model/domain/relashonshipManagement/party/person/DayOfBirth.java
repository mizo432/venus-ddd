package org.venuspj.values.model.domain.relashonshipManagement.party.person;

import org.venuspj.ddd.model.values.primitives.AbstractMonthDayValue;

public class DayOfBirth extends AbstractMonthDayValue<DayOfBirth> {

    public static DayOfBirth empty() {
        return new DayOfBirth();
    }
}
