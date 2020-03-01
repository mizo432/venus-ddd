package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.util.objects2.Objects2;

import java.time.temporal.Temporal;

public class HistoryItem<T extends Temporal, I extends Value<I>> extends AbstractValue<HistoryItem<T, I>> {

    private Interval<T> interval;
    private I item;

    public HistoryItem(Interval<T> anInterval, I anItem) {
        interval = anInterval;
        item = anItem;
    }

    I getItem() {
        return item;

    }

    Interval<T> getInterval() {
        return interval;

    }

    @Override
    public boolean sameValueAs(HistoryItem<T, I> other) {
        return equals(other);

    }

    @Override
    public boolean isEmpty() {
        return item.isEmpty() && interval.isEmpty();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HistoryItem<?, ?> that = (HistoryItem<?, ?>) o;
        return Objects2.equal(item, that.item) &&
                Objects2.equal(interval, that.interval);

    }

    @Override
    public int hashCode() {
        return Objects2.hash(item, interval);

    }


    public boolean isContinuous(HistoryItem<T, I> aNextHistoryItem) {
        return interval.isContinuousTo(aNextHistoryItem.interval);

    }

    /**
     * 次履歴アイテムをマージします。
     *
     * @param aNextHistoryItem 次履歴アイテム
     * @return マージ後の履歴アイテム
     */
    public HistoryItem<T, I> merge(HistoryItem<T, I> aNextHistoryItem) {
        Interval<T> newInterval = interval.marge(aNextHistoryItem.interval);

        return HistoryItem.createFrom(newInterval, item);

    }

    public static <T extends Temporal, V extends Value<V>> HistoryItem<T, V> createFrom(Interval<T> anInterval, V anItem) {
        return new HistoryItem<>(anInterval, anItem);

    }

    /**
     * 終了モーメントを調整します。
     *
     * @param aNextHistoryItem 次履歴アイテム
     * @return 調整後の履歴アイテム
     */
    public HistoryItem<T, I> adjustEndMoment(HistoryItem<T, I> aNextHistoryItem) {
        Interval<T> newInterval = interval.adjustEndMoment(aNextHistoryItem.interval);
        return HistoryItem.createFrom(newInterval, item);

    }

    /**
     * インターバルと検査インターバルが重なっているかを判定する.
     *
     * @param otherNextHistoryItem 検査インターバル
     * @return インターバルが重なっている場合はtrueを返却する
     */
    public boolean isOverlap(HistoryItem<T, I> otherNextHistoryItem) {
        return interval.isOverlap(otherNextHistoryItem.interval);

    }

    /**
     * 履歴アイテムで保持しているアイテムが検査履歴アイテムのアイテムと一致しているか判定する.
     *
     * @param anOtherHistoryItem 検査履歴アイテム
     * @return アイテムが一致している場合trueを返却する
     */
    public boolean sameItemAs(HistoryItem<T, I> anOtherHistoryItem) {
        return item.sameValueAs(anOtherHistoryItem.item);

    }

    /**
     * ターゲットモーメントがインターバルに含まれているかを判定する
     *
     * @param aTargetMoment ターゲットモーメント
     * @return 含まれている場合trueを返却する
     */
    public boolean contains(Moment<T> aTargetMoment) {
        return interval.contains(aTargetMoment);

    }

}

