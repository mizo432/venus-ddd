package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.Name;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class OoAzaInformation implements Value<OoAzaInformation> {
    private Name name = Name.empty();

    OoAzaInformation(Name aName) {
        name = aName;

    }

    public OoAzaInformation() {

    }

    public static OoAzaInformation empty() {
        return new OoAzaInformation();

    }

    public static OoAzaInformation of(Name aName) {
        return new OoAzaInformation(aName);
    }


    @Override
    public boolean sameValueAs(OoAzaInformation other) {
        return equals(other);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OoAzaInformation that = (OoAzaInformation) o;
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

    @Override
    public String toString() {
        return toStringHelper(this)
                .defaultConfig()
                .toString();

    }
}
