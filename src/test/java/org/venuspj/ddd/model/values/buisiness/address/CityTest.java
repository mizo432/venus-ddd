package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.json.JsonFilter;
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

        FilterProvider filters = new SimpleFilterProvider().addFilter("value", new JsonFilter());
        String json = objectMapper.writer(filters).writeValueAsString(target);
        System.out.println(json);

        City actual = objectMapper.readValue(json, City.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson2() throws JsonProcessingException {
        City target = City.empty();
        ObjectMapper objectMapper = new ObjectMapper();

        FilterProvider filters = new SimpleFilterProvider().addFilter("value", new JsonFilter());
        String json = objectMapper.writer(filters).writeValueAsString(target);
        System.out.println(json);

        City actual = objectMapper.readValue(json, City.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    private static class CityMock {
        public static City full() {
            return City.of(CityIdentifier.of(1L), CityInformation.of(CityCode.of("001"), Name.of("前橋市")));
        }

        public static City one() {
            return City.of(CityIdentifier.of(1L), CityInformation.of(CityCode.of("001"), Name.of("前橋市")));
        }

        public static City two() {
            return City.of(CityIdentifier.of(2L), CityInformation.of(CityCode.of("002"), Name.of("高崎市")));
        }
    }
}
