package org.venuspj.ddd.model.values.buisiness.datetime;

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

    @Override
    public int compareTo(Moment<T> o) {
        return 0;
    }

    public static <T extends Temporal> Moment<T> of(T aValue) {
        return new Moment(aValue);

    }

}
