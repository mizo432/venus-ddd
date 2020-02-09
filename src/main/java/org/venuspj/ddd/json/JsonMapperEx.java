package org.venuspj.ddd.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class JsonMapperEx {
    public String writeValueAsString(Object aValue) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FilterProvider filters = new SimpleFilterProvider().addFilter("value", new JsonFilter());
            return objectMapper.writer(filters).writeValueAsString(aValue);

        } catch (JsonProcessingException e) {
            throw new JsonProcessingRuntimeException(e);
        }
    }

    public <T> T readValue(String json, Class<T> aClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FilterProvider filters = new SimpleFilterProvider().addFilter("value", new JsonFilter());
            return objectMapper.readValue(json, aClass);

        } catch (JsonProcessingException e) {
            throw new JsonProcessingRuntimeException(e);

        }

    }
}
