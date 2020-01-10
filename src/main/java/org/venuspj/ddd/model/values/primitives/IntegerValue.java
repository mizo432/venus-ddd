package org.venuspj.ddd.model.values.primitives;

public interface IntegerValue<ISV extends IntegerValue<ISV>> extends SingleValue<Integer, ISV> {

    Integer asInteger();

    String asText();

    Integer getValue();

}
