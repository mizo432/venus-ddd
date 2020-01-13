package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractSingleValue;

import java.time.LocalDate;

import static org.venuspj.util.objects2.Objects2.isNull;

public class AbstractDateValue<ADSV extends AbstractDateValue<ADSV>>
        extends AbstractSingleValue<LocalDate, ADSV> implements DateValue<ADSV> {

    protected AbstractDateValue() {
    }

    protected AbstractDateValue(LocalDate value) {
        super(value);

    }

    @Override
    public String asText() {
        return value.toString();
    }

    @Override
    public int compareTo(ADSV o) {
        if (isNull(o))
            return 0;
        if (org.venuspj.util.objects2.Objects2.equal(value, o.value))
            return 0;
        if (value.isBefore(o.value))
            return -1;
        return 1;
    }

    @Override
    public LocalDate asDate() {
        return value;
    }

}
