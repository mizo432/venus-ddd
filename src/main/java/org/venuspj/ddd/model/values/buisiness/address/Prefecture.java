package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.venuspj.ddd.model.entity.AbstractEntity;

public class Prefecture extends AbstractEntity<Prefecture, PrefectureIdentifier, PrefectureInformation> {

    public Prefecture() {
        super(PrefectureIdentifier.empty(), PrefectureInformation.empty());
    }

    Prefecture(PrefectureIdentifier anIdentifier, PrefectureInformation anEntityInfo) {
        super(anIdentifier, anEntityInfo);
    }

    @JsonIgnore
    public boolean isEmpty() {
        return getIdentifier().isEmpty() &&
                getEntityInfo().isEmpty();

    }
}
