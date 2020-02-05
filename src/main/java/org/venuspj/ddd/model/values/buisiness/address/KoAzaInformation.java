package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.Name;

public class KoAzaInformation implements Value<KoAzaInformation> {
    private Name name = Name.empty();

    public static KoAzaInformation empty() {
        return new KoAzaInformation();

    }

    @Override
    public boolean sameValueAs(KoAzaInformation other) {
        return false;

    }

    @Override
    public boolean isEmpty() {
        return name.isEmpty();

    }
}
