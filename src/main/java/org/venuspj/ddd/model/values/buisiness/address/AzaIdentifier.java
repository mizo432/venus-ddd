package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class AzaIdentifier extends AbstractEntityLongIdentifier<Aza, AzaIdentifier> {
    public AzaIdentifier(Long aValue) {
        super(Aza.class, aValue);

    }

    public AzaIdentifier() {
        super(Aza.class);
    }

    public static AzaIdentifier empty() {
        return new AzaIdentifier();
    }

    @Override
    public boolean sameValueAs(AzaIdentifier other) {
        if (this == other) return true;
        return equal(this.kind, other.kind)
                && equal(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (isNull(o) || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        AzaIdentifier that = (AzaIdentifier) o;
        return sameValueAs(that);
    }

}
