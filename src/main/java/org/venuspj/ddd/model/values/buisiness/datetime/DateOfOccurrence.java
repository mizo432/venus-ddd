package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.primitives.AbstractDateValue;
import org.venuspj.util.dateProvider.DateProvider;

import java.time.LocalDate;

/**
 * 発生日
 */
public class DateOfOccurrence extends AbstractDateValue<DateOfOccurrence> {

    public DateOfOccurrence(LocalDate aValue) {
        super(aValue);
    }

    public static DateOfOccurrence now() {
        return DateOfOccurrence.of(DateProvider.currentLocalDate());

    }

    public static DateOfOccurrence of(LocalDate aValue) {
        return new DateOfOccurrence(aValue);

    }
}
