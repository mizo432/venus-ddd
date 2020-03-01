package org.venuspj.ddd.json;

import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

public class JsonFillerTest {

    @Test
    @Tag(TestSize.SMALL)
    public void writer() {
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("value", new JsonFilter());
        PropertyFilter actual = filters.getDefaultFilter();
        System.out.println(actual);
//        String actual = new ObjectMapper().writer(filters).writeValueAsString(dtoObject);
    }
}
