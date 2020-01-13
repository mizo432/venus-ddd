package org.venuspj.ddd.model.values.primitives;

/**
 * Created by mizoguchi on 2017/01/22.
 */
public interface StringValue<T extends StringValue<T>> extends SingleValue<String, T> {

    String asText();

    String getValue();

}
