package org.venuspj.ddd.model.forTest.model.concrete.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.name.Name;
import org.venuspj.util.objects2.Objects2;

public class ConcreteInfo implements Value<ConcreteInfo> {

    private Name name = Name.empty();

    public ConcreteInfo(Name aName) {
        name = aName;
    }

    public ConcreteInfo() {

    }

    public Name getName() {
        return name;
    }

    public static ConcreteInfo empty() {
        return new ConcreteInfo();

    }

    public static ConcreteInfo of(Name aName) {
        return new ConcreteInfo(aName);

    }

    @Override
    public boolean sameValueAs(ConcreteInfo other) {
        return equals(other);

    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return name.isEmpty();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConcreteInfo that = (ConcreteInfo) o;
        return Objects2.equal(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects2.hash(name);
    }
}
