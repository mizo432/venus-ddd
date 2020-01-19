package org.venuspj.ddd.model.values.buisiness.definition;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.description.Description;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.nonNull;

/**
 * 見出し語と説明のペア.
 * 文字列系の値オブジェクト。
 */
public class Definition implements Value<Definition> {
    private Heading heading = Heading.empty();
    private Description description = Description.empty();

    Definition() {

    }

    Definition(Heading aHeading, Description aDescription) {

    }

    @Override
    public boolean sameValueAs(Definition other) {
        return nonNull(other) &&
                equal(heading, other.heading) &&
                equal(description, other.description);

    }
}
