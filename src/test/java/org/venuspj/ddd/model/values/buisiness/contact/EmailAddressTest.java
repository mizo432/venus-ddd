package org.venuspj.ddd.model.values.buisiness.contact;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
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
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(target);

        EmailAddress actual = objectMapper.readValue(json, EmailAddress.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }

    @Test
    @Tag(TestSize.SMALL)
    public void toJson2() throws JsonProcessingException {
        EmailAddress target = EmailAddress.empty();
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(target);

        EmailAddress actual = objectMapper.readValue(json, EmailAddress.class);

        assertThat(target.sameValueAs(actual))
                .isTrue();
    }


}
