package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public class PrefectureIdentifier extends AbstractEntityLongIdentifier<Prefecture, PrefectureIdentifier> {
    public PrefectureIdentifier() {
        super(Prefecture.class);

    }

    PrefectureIdentifier(Long aValue) {
        this();
        value = aValue;

    }

    public static PrefectureIdentifier empty() {
        return new PrefectureIdentifier();

    }

    public static PrefectureIdentifier of(Long aValue) {
        return new PrefectureIdentifier(aValue);

    }

    @Override
    public boolean sameValueAs(PrefectureIdentifier other) {
        return equals(other);

    }
}
