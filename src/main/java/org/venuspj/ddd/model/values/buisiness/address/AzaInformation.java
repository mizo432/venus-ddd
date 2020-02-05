package org.venuspj.ddd.model.values.buisiness.address;

import org.venuspj.ddd.model.values.Value;
import org.venuspj.ddd.model.values.buisiness.Name;

public class AzaInformation implements Value<AzaInformation> {
    private Name name = Name.empty();

    public static AzaInformation empty() {
        return new AzaInformation();
    }


    @Override
    public boolean sameValueAs(AzaInformation other) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return name.isEmpty();
    }

}
