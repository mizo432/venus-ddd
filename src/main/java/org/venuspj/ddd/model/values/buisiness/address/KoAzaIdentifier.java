package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

import static org.venuspj.util.objects2.Objects2.equal;
import static org.venuspj.util.objects2.Objects2.isNull;

public class KoAzaIdentifier extends AbstractEntityLongIdentifier<KoAza, KoAzaIdentifier> {
    public KoAzaIdentifier(Long aValue) {
        super(KoAza.class, aValue);

    }

    public KoAzaIdentifier() {
        super(KoAza.class);
    }

    public static KoAzaIdentifier empty() {
        return new KoAzaIdentifier();
    }

    @Override
    public boolean sameValueAs(KoAzaIdentifier other) {
        if (this == other) return true;
        return equal(this.kind, other.kind)
                && equal(this.value, other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (isNull(o) || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        KoAzaIdentifier that = (KoAzaIdentifier) o;
        return sameValueAs(that);
    }
}
