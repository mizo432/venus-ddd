package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class CityIdentifierTest {
    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        CityIdentifier target = CityIdentifier.empty();

        assertThat(target.sameValueAs(target))
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        CityIdentifier target = CityIdentifier.of(10L);

        assertThat(target.sameValueAs(target))
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson1() throws JsonProcessingException {
        CityIdentifier target = CityIdentifier.of(1L);
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(target);

        CityIdentifier actual = objectMapper.readValue(json, CityIdentifier.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson2() throws JsonProcessingException {
        CityIdentifier target = CityIdentifier.empty();
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(target);

        CityIdentifier actual = objectMapper.readValue(json, CityIdentifier.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

}
