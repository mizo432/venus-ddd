package org.venuspj.ddd.model.values.buisiness.note;

import org.venuspj.ddd.model.values.Value;

import static org.venuspj.util.objects2.Objects2.*;

/**
 * 見出し語と説明のペア.
 * 文字列系の値オブジェクト。
 */
public class Definition implements Value<Definition> {
    private HeadLine headLine = HeadLine.empty();
    private Description description = Description.empty();

    Definition() {

    }

    Definition(HeadLine aHeadLine, Description aDescription) {
        headLine = aHeadLine;
        description = aDescription;

    }

    public static Definition empty() {
        return new Definition();
    }

    public static Definition of(HeadLine aHeadLine, Description aDescription) {
        return new Definition(aHeadLine, aDescription);
    }

    @Override
    public boolean sameValueAs(Definition other) {
        return nonNull(other) &&
                equal(headLine, other.headLine) &&
                equal(description, other.description);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (isNull(o) || getClass() != o.getClass()) return false;
        Definition that = (Definition) o;
        return sameValueAs(that);

    }

    @Override
    public int hashCode() {
        return org.venuspj.util.objects2.Objects2.hash(headLine, description);

    }

    public boolean isEmpty() {
        return headLine.isEmpty() &&
                description.isEmpty();
    }
}
