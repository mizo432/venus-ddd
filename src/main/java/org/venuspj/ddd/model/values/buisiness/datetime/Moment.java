package org.venuspj.ddd.model.values.buisiness.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.Temporal;

/**
 * 瞬間的なオブジェクトへのインターフェイス.
 *
 * @param <T> Temporalの型
 */
public class Moment<T extends Temporal>
        extends AbstractMomentValue<T, Moment<T>> {

    public Moment(T aValue) {
        super(aValue);

    }

    public Moment() {
        super();
    }

    public static <T extends Temporal> Moment<T> empty() {
        return new Moment<>();
    }

    @Override
    public int compareTo(Moment<T> o) {
        return 0;
    }

    public static <T extends Temporal> Moment<T> of(T aValue) {
        return new Moment(aValue);

    }

    public Moment<T> maxMoment() {
        if (value instanceof Year)
            return (Moment<T>) of(Year.of(9999));

        if (value instanceof YearMonth)
            return (Moment<T>) of(YearMonth.of(9999, 12));

        if (value instanceof LocalDate)
            return (Moment<T>) of(LocalDate.of(9999, 12, 31));

        if (value instanceof LocalDateTime)
            return (Moment<T>) of(LocalDateTime.of(10000, 1, 1, 0, 0, 0, 0).minusNanos(1L));

        throw new TemporalTypeIsNonMatchException(value.getClass());

    }
}
