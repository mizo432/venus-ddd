package org.venuspj.ddd.model.values.jsonfillter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import org.venuspj.ddd.model.values.Value;

public class JsonFilter extends SimpleBeanPropertyFilter {
    @Override
    public void serializeAsField
            (Object pojo, JsonGenerator jsonGenerator, SerializerProvider provider, PropertyWriter writer)
            throws Exception {
        if (include(writer)) {
            if (!writer.getType().isTypeOrSubTypeOf(Value.class)) {
                writer.serializeAsField(pojo, jsonGenerator, provider);
                return;
            }

            Value<?> value = ((Value) pojo);
            if (!value.isEmpty()) {
                writer.serializeAsField(pojo, jsonGenerator, provider);
            }
        } else if (!jsonGenerator.canOmitFields()) {
            writer.serializeAsOmittedField(pojo, jsonGenerator, provider);
        }
    }

}
