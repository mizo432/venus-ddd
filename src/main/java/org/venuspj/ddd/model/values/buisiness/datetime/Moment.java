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
 * @param <M> モーメントの型
 */
public class Moment
        extends AbstractMomentValue<Temporal, Moment> {

    public Moment(Temporal aValue) {
        super(aValue);
    }

    public static Moment of(LocalDate aValue) {
        return new Moment(aValue);

    }

    public static Moment of(LocalDateTime aValue) {
        return new Moment(aValue);
    }

    public static Moment of(YearMonth aValue) {
        return new Moment(aValue);

    }

    public static Moment of(Year aValue) {
        return new Moment(aValue);

    }

    @Override
    public int compareTo(Moment o) {
        return 0;
    }
}
