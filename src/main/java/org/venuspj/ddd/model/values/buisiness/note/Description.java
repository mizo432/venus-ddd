package org.venuspj.ddd.model.values.buisiness.note;

import org.venuspj.ddd.model.values.primitives.AbstractListValue;

import java.util.Collection;


/**
 * 説明（複数行のテキスト）
 */
public class Description extends AbstractListValue<Line, Description> {
    public Description(Collection<Line> aCollection) {
        super(aCollection);

    }

    public Description() {

    }

    public static Description of(Collection<Line> aList) {
        return new Description(aList);

    }

    public static Description empty() {
        return new Description();

    }


    public boolean isEmpty() {
        return value.isEmpty();

    }
}
