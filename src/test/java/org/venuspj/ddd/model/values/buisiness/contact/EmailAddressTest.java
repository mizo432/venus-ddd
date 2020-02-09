package org.venuspj.ddd.model.values.buisiness.contact;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.venuspj.ddd.json.JsonMapperEx;
import org.venuspj.tests.constants.TestSize;

import static org.assertj.core.api.Assertions.assertThat;

public class EmailAddressTest {

    @Test
    @Tag(TestSize.SMALL)
    public void of() {
        EmailAddress target = EmailAddress.of("testData");
        assertThat(target)
                .isNotNull();
        assertThat(target.isPresent())
                .isTrue();

    }

    @Test
    @Tag(TestSize.SMALL)
    public void empty() {
        EmailAddress target = EmailAddress.empty();
        assertThat(target)
                .isNotNull();
        assertThat(target.isEmpty())
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson1() throws JsonProcessingException {
        EmailAddress target = EmailAddress.of("dummy@gmail.com");
        JsonMapperEx objectMapper = new JsonMapperEx();

        String json = objectMapper.writeValueAsString(target);

        EmailAddress actual = objectMapper.readValue(json, EmailAddress.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson2() throws JsonProcessingException {
        EmailAddress target = EmailAddress.empty();
        JsonMapperEx objectMapper = new JsonMapperEx();

        String json = objectMapper.writeValueAsString(target);

        EmailAddress actual = objectMapper.readValue(json, EmailAddress.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }


}
