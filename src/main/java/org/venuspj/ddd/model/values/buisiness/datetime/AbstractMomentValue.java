package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.AbstractSingleValue;

import java.time.temporal.Temporal;

/**
 * 瞬間的なオブジェクトへのインターフェイス.
 *
 * @param <T> Temporalの型
 * @param <M> モーメントの型
 */
public abstract class AbstractMomentValue<T extends Temporal, M extends AbstractMomentValue<T, M>>
        extends AbstractSingleValue<T, M> implements MomentValue<T, M> {

    public AbstractMomentValue(T aValue) {
        super(aValue);

    }

    public AbstractMomentValue() {
        super();

    }
}
