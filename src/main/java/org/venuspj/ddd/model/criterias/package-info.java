/**
 * 検索条件の共通部品を格納するパッケージ.
 * <p>
 * Javaの基本参照型ごとに共通部品として作成してある<br>
 * <table border="1">
 * <caption>型ごとに設定できる値</caption>
 * <tr><th>プロパティ</th><th>SQL上の表現</th><th>Boolean</th><th>Integer</th><th>Long</th><th>BigInteger</th><th>BigDecimal</th><th>String</th><th>Date</th><th>Time</th><th>LocalDate</th><th>LocalDateTime</th></tr>
 * <tr><th>equalTo</th><th>=</th><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td></tr>
 * <tr><th>notEqualTo</th><th>!=</th><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td></tr>
 * <tr><th>isNull</th><th>is null</th><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td></tr>
 * <tr><th>isNotNull</th><th>is not null</th><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td></tr>
 * <tr><th>moreThan</th><th>{@code > }</th><td></td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td></tr>
 * <tr><th>moreOrEqual</th><th>{@code >= }</th><td></td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td></tr>
 * <tr><th>lessThan</th><th>{@code < }</th><td></td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td></tr>
 * <tr><th>lessOrEqual</th><th>{@code <= }</th><td></td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td></tr>
 * <tr><th>from, to</th><th>between A and B</th><td></td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td></tr>
 * <tr><th>includes</th><th>in (A,B,C)</th><td></td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td></td><td></td><td>〇</td><td></td></tr>
 * <tr><th>excludes</th><th>not in (A,B,C)</th><td></td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td>〇</td><td></td><td></td><td>〇</td><td></td></tr>
 * <tr><th>partialMatch</th><th>like  '%hoge%'</th><td></td><td></td><td></td><td></td><td></td><td>〇</td><td></td><td></td><td></td><td></td></tr>
 * <tr><th>forwardMatch</th><th>like 'hoge%'</th><td></td><td></td><td></td><td></td><td></td><td>〇</td><td></td><td></td><td></td><td></td></tr>
 * <tr><th>backwardMatch</th><th>like '%hoge'</th><td></td><td></td><td></td><td></td><td></td><td>〇</td><td></td><td></td><td></td><td></td></tr>
 * </table>
 *
 * <h2>作成例</h2>
 * Ja用の検索条件
 * <p>
 * public class JaCriteria {<br>
 *
 * <code>  private LongCriteria jaIdCriteria = new LongCriteria();</code><br>
 * <br>
 * <code>  public LongCriteria getJaIdCriteria(){</code><br>
 * <code>    return jaIdCriteria;</code><br>
 * <code>  }</code><br>
 * <br>
 *   ：<br>
 *   ：<br>
 * <br>
 * <code>}</code><br>
 *
 * <h2>利用例</h2>
 * JaCriteria jaCriteria = new JaCriteria();<br>
 * jaCriteria.jaIdCriteria.setEqualTo(1);<br>
 * Ja ja = jaDao.findBy(jaCriteria);<br>
 *
 * <h2>リストタイプの条件の指定方法 includes, excludes</h2>
 * jaCriteria.jaIdCriteria.getIncludes().addAll(anyList); <br>
 * jaCriteria.jaIdCriteria.getIncludes().add(anyList); <br>
 * jaCriteria.jaIdCriteria.getIncludes().clean(); <br>
 */
package org.venuspj.ddd.model.criterias;
