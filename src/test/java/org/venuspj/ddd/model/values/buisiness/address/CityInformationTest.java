package org.venuspj.ddd.model.values.buisiness.address;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.json.JsonMapperEx;
import org.venuspj.ddd.model.values.buisiness.name.Name;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class CityInformationTest {
    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        CityInformation target = CityInformation.empty();

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        CityInformation target = CityInformation.of(CityCode.empty(), Name.empty());

        boolean actual = target.isEmpty();

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs1() {
        CityInformation target = CityInformation.empty();

        boolean actual = target.sameValueAs(target);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs2() {
        CityInformation target = CityInformation.empty();

        boolean actual = target.sameValueAs(null);

        assertThat(actual)
                .isFalse();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void sameValueAs3() {
        CityInformation arg = CityInformation.empty();
        CityInformation target = CityInformation.empty();

        boolean actual = target.sameValueAs(arg);

        assertThat(actual)
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void toString1() {
        CityInformation target = CityInformation.empty();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void equals1() {
        SimpleAddressInformation arg = SimpleAddressInformation.empty();
        CityInformation target = CityInformation.empty();
        boolean actual = target.equals(arg);
        assertThat(actual)
                .isFalse();

//        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void equals2() {
        CityInformation target = CityInformation.empty();
        boolean actual = target.equals(target);
        assertThat(actual)
                .isTrue();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void equals3() {
        CityInformation arg = CityInformation.empty();
        CityInformation target = CityInformation.empty();
        boolean actual = target.equals(arg);
        assertThat(actual)
                .isTrue();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void equals4() {
        CityInformation arg = CityInformationMock.two();
        CityInformation target = CityInformationMock.one();
        boolean actual = target.equals(arg);
        assertThat(actual)
                .isFalse();

        System.out.println(target.toString());

    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson1() throws JsonProcessingException {
        CityInformation target = CityInformation.builder()
                .withCityCode(CityCode.of("001"))
                .withName(Name.of("前橋市"))
                .build();
        JsonMapperEx objectMapper = new JsonMapperEx();

        String json = objectMapper.writeValueAsString(target);

        CityInformation actual = objectMapper.readValue(json, CityInformation.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson2() throws JsonProcessingException {
        CityInformation target = CityInformation.empty();
        JsonMapperEx objectMapper = new JsonMapperEx();

        String json = objectMapper.writeValueAsString(target);

        CityInformation actual = objectMapper.readValue(json, CityInformation.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    private static class CityInformationMock {
        public static CityInformation empty() {
            return CityInformation.empty();
        }

        public static CityInformation existCityCode() {
            return CityInformation.of(CityCode.of("001"), Name.empty());
        }

        public static CityInformation existName() {
            return CityInformation.of(CityCode.empty(), Name.empty());
        }

        public static CityInformation full() {
            return one();
        }

        public static CityInformation one() {
            return CityInformation.of(CityCode.of("001"), Name.of("前橋市"));
        }

        public static CityInformation two() {
            return CityInformation.of(CityCode.of("002"), Name.of("高崎市"));
        }
    }


}
