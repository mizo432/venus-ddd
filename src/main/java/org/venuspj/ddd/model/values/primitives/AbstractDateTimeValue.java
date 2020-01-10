package org.venuspj.ddd.model.values.primitives;

import org.venuspj.ddd.model.values.AbstractSingleValue;

import java.time.LocalDateTime;

import static org.venuspj.util.objects2.Objects2.isNull;

public class AbstractDateTimeValue<ASV extends AbstractDateTimeValue<ASV>>
        extends AbstractSingleValue<LocalDateTime, ASV> implements DateTimeValue<ASV> {

    protected AbstractDateTimeValue() {
    }

    protected AbstractDateTimeValue(LocalDateTime value) {
        super(value);

    }


    @Override
    public String asText() {
        return value.toString();

    }

    @Override
    public int compareTo(ASV o) {
        if (isNull(o))
            return 0;
        if (org.venuspj.util.objects2.Objects2.equal(value, o.value))
            return 0;
        if (value.isBefore(o.value))
            return -1;
        return 1;
    }

    @Override
    public LocalDateTime asDateTime() {
        return value;

    }

}
