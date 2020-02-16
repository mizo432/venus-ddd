package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntity;
import org.venuspj.ddd.model.values.buisiness.name.Name;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.hash;

public class Aza extends AbstractEntity<Aza, AzaIdentifier> {
    private AzaCode azaCode = AzaCode.empty();
    private Name name = Name.empty();
    private Name kanaName = Name.empty();

    Aza(AzaIdentifier anAzaIdentifier, AzaCode anAzaCode, Name aName, Name aKanaName) {
        super(anAzaIdentifier);
        azaCode = anAzaCode;
        name = aName;
        kanaName = aKanaName;

    }

    public Aza() {
        super(AzaIdentifier.empty());
    }

    public static Aza empty() {
        return new Aza();

    }

    public static Aza of(AzaIdentifier anAzaIdentifier, AzaCode anAzaCode, Name aName, Name aKanaName) {
        return new Aza(anAzaIdentifier, anAzaCode, aName, aKanaName);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aza aza = (Aza) o;
        return equal(azaCode, aza.azaCode) &&
                equal(name, aza.name) &&
                equal(kanaName, aza.kanaName);
    }

    @Override
    public int hashCode() {
        return hash(super.hashCode(), azaCode, name, kanaName);
    }
}
