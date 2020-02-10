package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.AbstractValue;
import org.venuspj.ddd.model.values.buisiness.Name;
import org.venuspj.util.objects2.Objects2;

public class AzaInformation extends AbstractValue<AzaInformation> {
    private Name name = Name.empty();

    public AzaInformation(Name aName) {
        name = aName;
    }

    public AzaInformation() {

    }

    public static AzaInformation empty() {
        return new AzaInformation();

    }

    public static AzaInformation of(Name aName) {
        return new AzaInformation(aName);

    }

    @Override
    public boolean sameValueAs(AzaInformation other) {
        return equals(other);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AzaInformation that = (AzaInformation) o;
        return Objects2.equal(name, that.name);

    }

    @Override
    public int hashCode() {
        return Objects2.hash(name);

    }

    @Override
    @JsonIgnore
    public boolean isEmpty() {
        return name.isEmpty();

    }

    public Name getName() {
        return name;
    }

}
