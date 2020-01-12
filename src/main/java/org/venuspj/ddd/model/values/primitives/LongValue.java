package org.venuspj.ddd.model.values.primitives;

public interface LongValue<ISV extends LongValue<ISV>> extends SingleValue<Long, ISV> {

    Long asInteger();

    String asText();

    Long getValue();

}
