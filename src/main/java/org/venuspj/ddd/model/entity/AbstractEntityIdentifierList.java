package org.venuspj.ddd.model.entity;

import org.venuspj.ddd.model.values.primitives.AbstractListValue;

/**
 * エンティティの識別子をリスト形式で保持するための基底クラス
 *
 * @param <EI>  エンティティの識別子
 * @param <EIL>
 */
public abstract class AbstractEntityIdentifierList<EI extends EntityIdentifier<EI>, EIL extends AbstractEntityIdentifierList<EI, EIL>> extends AbstractListValue<EI, EIL> {

}
