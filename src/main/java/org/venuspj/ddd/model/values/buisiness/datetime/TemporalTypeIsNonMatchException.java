package org.venuspj.ddd.model.values.buisiness.datetime;

import java.time.temporal.Temporal;

public class TemporalTypeIsNonMatchException extends RuntimeException {
    private final Class<? extends Temporal> temporalClass;

    public TemporalTypeIsNonMatchException(Class<? extends Temporal> aClass) {
        super("対象額のtemporalClassです. " + aClass.getSimpleName());
        temporalClass = aClass;
    }

    public Class<? extends Temporal> getTemporalClass() {
        return temporalClass;

    }

}
