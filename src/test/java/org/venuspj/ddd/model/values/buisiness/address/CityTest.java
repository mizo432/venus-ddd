package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.model.values.buisiness.Name;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class CityTest {

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        City target = City.empty();
        assertThat(target)
                .isNotNull();

        System.out.println(true);
    }

    @Test
    @Tag(TestSize.SMALL)
    public void getCityInformation() {
        City target = City.of(CityIdentifier.empty(), CityInformation.empty());
        assertThat(target.getCityInformation())
                .isNotNull();

        System.out.println(true);
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson1() throws JsonProcessingException {
        City target = CityTest.CityMock.full();
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(target);

        City actual = objectMapper.readValue(json, City.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson2() throws JsonProcessingException {
        City target = City.empty();
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(target);

        City actual = objectMapper.readValue(json, City.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    private static class CityMock {
        public static City full() {
            return City.of(CityIdentifier.of(1L), CityInformation.of(Name.of("前橋市")));
        }
    }
}
