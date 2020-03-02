package org.venuspj.ddd.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.time.temporal.Temporal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 履歴アイテムを複数持つもの
 *
 * @param <T> テンポラル(Year/YearMonth/LocalDate/LocalDateTime)
 * @param <V> 保持するアイテム
 */
public class HistoryItems<T extends Temporal, V extends Value<V>>
        extends AbstractListValue<HistoryItem<T, V>, HistoryItems<T, V>> {

    /**
     * コンストラクター.
     *
     * @param aCollection 保持する履歴アイテムのコレクション.
     */
    public HistoryItems(Collection<HistoryItem<T, V>> aCollection) {
        value.addAll(aCollection);

    }

    /**
     * ファクトリーメソッド
     *
     * @param aCollection コレクション
     * @param <T>         テンポラル(Year/YearMonth/LocalDate/LocalDateTime)
     * @param <V>         保持するアイテム
     * @return 履歴アイテムを複数持つもの
     */
    public static <T extends Temporal, V extends Value<V>> HistoryItems<T, V> of(List<HistoryItem<T, V>> aCollection) {
        return new HistoryItems<>(aCollection);

    }

    /**
     * ターゲットモーメントに合致するアイテムの一覧を取得する.
     *
     * @param aTargetMoment ターゲットモーメント
     * @return アイテムのリスト
     */
    public List<V> selectBy(Moment<T> aTargetMoment) {
        return value
                .stream()
                .filter(historyItem -> historyItem.contains(aTargetMoment))
                .map(HistoryItem::getItem)
                .collect(Collectors.toList());

    }
}
