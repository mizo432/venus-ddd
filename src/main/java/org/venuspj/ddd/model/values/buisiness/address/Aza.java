package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.values.buisiness.name.Name;

import static org.venuspj.util.objects2.Objects2.hash;

public class Aza extends AbstractEntity<Aza, AzaIdentifier> {
    private Name name = Name.empty();

    Aza(AzaIdentifier anAzaIdentifier, Name aName) {
        super(anAzaIdentifier);
        name = aName;
    }

    public Aza() {
        super(AzaIdentifier.empty());
    }

    public static Aza empty() {
        return new Aza();

    }

    public static Aza of(AzaIdentifier anAzaIdentifier, Name aName) {
        return new Aza(anAzaIdentifier, aName);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aza aza = (Aza) o;
        return name.equals(aza.name);
    }

    @Override
    public int hashCode() {
        return hash(super.hashCode(), name);

    }
}
