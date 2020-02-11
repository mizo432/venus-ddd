package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.entity.AbstractEntityLongIdentifier;

public class PrefectureIdentifier extends AbstractEntityLongIdentifier<PrefectureIdentifier> {
    public PrefectureIdentifier() {
        super(AbstractPrefecture.class);

    }

    PrefectureIdentifier(Long aValue) {
        super(AbstractPrefecture.class, aValue);

    }

    public static PrefectureIdentifier empty() {
        return new PrefectureIdentifier();

    }

    public static PrefectureIdentifier of(Long aValue) {
        return new PrefectureIdentifier(aValue);

    }

}
