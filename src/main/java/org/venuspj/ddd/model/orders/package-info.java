/**
 * 並び順を管理するクラス
 * <h2>利用方法</h2>
 * <h3>順番指定が不要な場合</h3>
 * <code>
 * Orders.empty();
 * </code>
 *
 * <h3>順番指定をする場合</h3>
 * <p>
 *     <ul>
 *         <li>JAID で並びかえる(デフォルト昇順)</li>
 *         <li>降順指定をするばあい 明示的に昇順を指定する場合はORDERS.ASCを指定する</li>
 *         <li>JANAME で並びかえる(デフォルト昇順)</li>
 * </ul>
 * <pre>
 * {@code
 *   Orders
 *     .empty()
 *     .addOrder("JAID"),
 *     .addOrder("JaCode", ORDER.DESC)
 *     .addOrder("JANAME")
 *   ;
 * }
 * </pre>
 *
 * <h3>記述例</h3>
 * 画面上のチェックボックスにより動的に昇降順を変える場合には下記のようなメソッドを検討して下さい。
 * <pre>
 * {@code
 * private Order createFrom(Boolean checked)
 *     if(checked) return Order.ASC;
 *     return Order.DESC;
 * }
 * }
 * </pre>
 */
package org.venuspj.ddd.model.orders;
