package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.Name;
import org.venuspj.util.objects2.Objects2;

import static org.venuspj.util.objects2.Objects2.toStringHelper;

public class KoAzaInformation implements Value<KoAzaInformation> {
    private Name name = Name.empty();

    public KoAzaInformation(Name aName) {
        name = aName;
    }

    public KoAzaInformation() {

    }

    public static KoAzaInformation empty() {
        return new KoAzaInformation();

    }

    public static KoAzaInformation of(Name aName) {
        return new KoAzaInformation(aName);

    }

    @Override
    public boolean sameValueAs(KoAzaInformation other) {
        return equals(other);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KoAzaInformation that = (KoAzaInformation) o;
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
