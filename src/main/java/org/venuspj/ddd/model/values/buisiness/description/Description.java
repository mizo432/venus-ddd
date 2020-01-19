package org.venuspj.ddd.model.values.buisiness.description;

import org.venuspj.ddd.model.values.buisiness.line.Line;
import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.util.Collection;
import java.util.List;


/**
 * 説明（複数行のテキスト）
 */
public class Description extends AbstractListValue<Line, Description> {
    public Description(Collection<Line> aCollection) {
        super(aCollection);

    }

    public Description() {

    }

    public static Description of(List<Line> aList) {
        return new Description(aList);
    }

    public static Description empty() {
        return new Description();
    }


}