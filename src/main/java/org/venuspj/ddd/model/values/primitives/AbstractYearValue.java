package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractSingleValue;

import java.time.Year;

import static org.venuspj.util.objects2.Objects2.isNull;

public class AbstractYearValue<AYSV extends AbstractYearValue<AYSV>>
        extends AbstractSingleValue<Year, AYSV> implements YearValue<AYSV> {

    protected AbstractYearValue() {
    }

    protected AbstractYearValue(Year value) {
        super(value);

    }

    @Override
    public String asText() {
        return value.toString();
    }

    @Override
    public int compareTo(AYSV o) {
        if (isNull(o))
            return 0;
        if (org.venuspj.util.objects2.Objects2.equal(value, o.value))
            return 0;
        if (value.isBefore(o.value))
            return -1;
        return 1;
    }

    @Override
    public Year asYear() {
        return value;

    }

}
