package org.venuspj.ddd.model.value;

/**
 * Created by mizoguchi on 2017/01/22.
 */
public interface StringValue<T extends StringValue<T>> extends Value<T> {

    String asText();

    String getValue();

}
