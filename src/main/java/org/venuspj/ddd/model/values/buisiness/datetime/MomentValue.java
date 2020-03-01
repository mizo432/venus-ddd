package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.SingleValue;

import java.time.temporal.Temporal;

/**
 * 瞬間的なオブジェクトへのインターフェイス.
 *
 * @param <T> Temporalの型
 * @param <M> モーメントの型
 */
public interface MomentValue<T extends Temporal, M extends MomentValue<T, M>> extends SingleValue<T, M> {

}
