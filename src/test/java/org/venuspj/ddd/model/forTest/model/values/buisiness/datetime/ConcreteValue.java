package org.venuspj.ddd.model.forTest.model.values.buisiness.datetime;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.name.Name;

import static org.venuspj.util.objects2.Objects2.*;

public class ConcreteValue implements Value<ConcreteValue> {
    private Name kanjiName = Name.empty();
    private Name kanaName = Name.empty();

    public ConcreteValue(Name aKanjiName, Name aKanaName) {
        kanjiName = aKanjiName;
        kanaName = aKanaName;
    }

    public static ConcreteValue createFrom(Name aKanjiName, Name aKanaName) {
        return new ConcreteValue(aKanjiName, aKanaName);
    }

    @Override
    public boolean sameValueAs(ConcreteValue other) {
        return equals(other);
    }

    @Override
    public boolean isEmpty() {
        return kanaName.isEmpty() && kanjiName.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConcreteValue that = (ConcreteValue) o;
        return equal(kanjiName, that.kanjiName) &&
                equal(kanaName, that.kanaName);
    }

    @Override
    public int hashCode() {
        return hash(kanjiName, kanaName);

    }

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();
    }
}
