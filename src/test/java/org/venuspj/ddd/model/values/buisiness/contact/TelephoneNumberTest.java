package org.venuspj.ddd.model.values.buisiness.contact;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.json.JsonMapperEx;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class TelephoneNumberTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        TelephoneNumber target = TelephoneNumber.of("testData");
        assertThat(target)
                .isNotNull();
        assertThat(target.isPresent())
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        TelephoneNumber target = TelephoneNumber.empty();
        assertThat(target)
                .isNotNull();
        assertThat(target.isEmpty())
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson1() throws JsonProcessingException {
        TelephoneNumber target = TelephoneNumber.of("01-2345-6789");
        JsonMapperEx objectMapper = new JsonMapperEx();

        String json = objectMapper.writeValueAsString(target);

        TelephoneNumber actual = objectMapper.readValue(json, TelephoneNumber.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson2() throws JsonProcessingException {
        TelephoneNumber target = TelephoneNumber.empty();
        JsonMapperEx objectMapper = new JsonMapperEx();

        String json = objectMapper.writeValueAsString(target);

        TelephoneNumber actual = objectMapper.readValue(json, TelephoneNumber.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

}
